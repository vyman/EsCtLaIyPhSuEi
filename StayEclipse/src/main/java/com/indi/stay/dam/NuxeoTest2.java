package com.indi.stay.dam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jboss.logging.Logger;
import org.nuxeo.ecm.automation.client.Constants;
import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.adapters.DocumentService;
import org.nuxeo.ecm.automation.client.adapters.VersionIncrement;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.ecm.automation.client.model.Document;
import org.nuxeo.ecm.automation.client.model.FileBlob;
import org.nuxeo.ecm.automation.client.model.PropertyMap;
public class NuxeoTest2 {

	/**
	 * @param args
	 */
	private static Logger logger = Logger.getLogger(NuxeoTest2.class);
	public static void main(String[] args) {
		FileInputStream in = null;
		try {
			logger.debug("TestWriteFile START");

			HttpAutomationClient client = new HttpAutomationClient("http://localhost:8080/nuxeo/site/automation");
			Session session = client.getSession("Administrator", "Administrator");

			String fileName = "Koala.jpg";
			String fileDescription = "This is a Nuxeo Automation Client test.";

			String filePath = "C:/Users/Vyman.Hm/Desktop/" + fileName;
			FileInputStream fis = new FileInputStream(filePath);
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			fis.close();

			// Get the nuxeo-SIB workspace
			Document root = (Document) session.newRequest(DocumentService.FetchDocument).set("value", "/default-domain/workspaces/SampleWS").execute();
//			Document root2 = (Document) session.newRequest(DocumentService.FetchDocument).set("value", "/SampleWS").execute();
			String customFolderName = "testWithNuxeoAutomationClient";
			String workingPath = "/default-domain/workspaces/SampleWS" + "/" + customFolderName;
			Document customFolder;
			try {
				customFolder = (Document) session.newRequest(DocumentService.FetchDocument).set("value", workingPath).execute();
				// customerFolder exists
			} catch (Exception e) {
				// customerFolder doesn't exist -> Create a Folder on nuxeo
				session.newRequest(DocumentService.CreateDocument).setInput(root).set("type", "Folder").set("name", customFolderName).set("properties", "dc:title=" + customFolderName).execute();
				customFolder = (Document) session.newRequest(DocumentService.FetchDocument).set("value", workingPath).execute();
			}

			// Create temp file
			File file = new File(fileName);
			// Write file content
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.close();

			FileBlob fb = new FileBlob(file);
			fb.setMimeType(FileBlob.getMimeTypeFromExtension(fileName));

			Document doc;
			// Check if doc exists, create it if it doesn't (-> catch Exception)
			try {

				doc = (Document) session.newRequest(DocumentService.FetchDocument).setHeader(Constants.HEADER_NX_SCHEMAS, "*").set("value", workingPath + "/" + fileName).execute();

				logger.warn("WARNING: file already exists, file ID: " + doc.getProperties().getMap("file:content").getString("data") + " -> Update it...");

				PropertyMap props = new PropertyMap();
				props.set("dc:title", fileName);
				props.set("dc:description", fileDescription);
				session.newRequest(DocumentService.SetBlob).setHeader(Constants.HEADER_NX_VOIDOP, "true").setInput(fb).set("document", doc.getId()).execute();
				session.newRequest(DocumentService.CreateVersion).setInput(doc).set("increment", VersionIncrement.MAJOR).execute();

			} catch (Exception e) {
				logger.warn(e.getMessage(), e);

				// doc doesn't exist -> create it

				PropertyMap props = new PropertyMap();
				props.set("dc:title", fileName);
				props.set("dc:description", fileDescription);

				// Create a File on nuxeo
				doc = (Document) session.newRequest(DocumentService.CreateDocument).setInput(customFolder).set("type", "File").set("name", fileName).set("properties", props).execute();
				// Uploading a file will return null since we used HEADER_NX_VOIDOP
				session.newRequest(DocumentService.SetBlob).setHeader(Constants.HEADER_NX_VOIDOP, "true").setInput(fb).set("document", workingPath + "/" + fileName).execute();
				// Create new version
				session.newRequest(DocumentService.CreateVersion).setInput(doc).set("increment", VersionIncrement.MAJOR).execute();
			}

			doc = (Document) session.newRequest(DocumentService.FetchDocument).setHeader(Constants.HEADER_NX_SCHEMAS, "*").set("value", workingPath + "/" + fileName).execute();

			// get the file content property
			PropertyMap map = doc.getProperties().getMap("file:content");
			// get the data URL
			String fileID = map.getString("data");
			logger.debug("Upload complete, file ID: " + fileID);

			client.shutdown();

			logger.debug("TestWriteFile END");
		} catch (Exception e) {
			logger.error("TestWriteFile ERROR: " + e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
		}

	}

}
