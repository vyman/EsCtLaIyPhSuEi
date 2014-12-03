package com.indi.stay.service.impl;

import java.io.File;

import org.nuxeo.ecm.automation.client.Constants;
import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.ecm.automation.client.model.Document;
import org.nuxeo.ecm.automation.client.model.FileBlob;
import org.nuxeo.ecm.automation.client.model.PropertyMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.indi.stay.service.NuxeoServerService;

@Service
public class NuxeoServerServiceImpl implements NuxeoServerService {

//	public static Session returnSession(){
//		try{
//			HttpAutomationClient client = new HttpAutomationClient(
//					"http://localhost:8080/nuxeo/site/automation");
//
//			Session session = client.getSession("Administrator", "Administrator");
//			return session;
//		}catch(Exception e){
//
//			return null;
//		}
//	}
	
	@Override
	public String persistImageAndReturnPath(CommonsMultipartFile commonsMultipartFile){
//		Session session =returnSession();
		try{
			HttpAutomationClient client = new HttpAutomationClient(
					"http://localhost:8080/nuxeo/site/automation");

			Session session = client.getSession("Administrator", "Administrator");
			Document root = (Document) session.newRequest("Document.Fetch").set(
					"value", "/").execute();
			Document doc=(Document) session.newRequest("Document.Create").setInput(root).set("type", "Folder").set(
					"name", "myfile_xyz").set("properties", "dc:title=My File_XYZ").execute();

			Document picdoc=(Document) session.newRequest("Document.Create").setInput(doc).set("type", "Picture").set(
					"name", "myfile_xyzv").set("properties", "dc:title=My_Pic").execute();

			File file = new File(commonsMultipartFile.getOriginalFilename());
			commonsMultipartFile.transferTo(file);
			FileBlob fb = new FileBlob(file);
			fb.setMimeType("image/jpeg");

			session.newRequest("Blob.Attach").setHeader(
					Constants.HEADER_NX_VOIDOP, "true").setInput(fb)
					.set("document", picdoc).execute();
			Document docimg = (Document) session.newRequest("Document.Fetch").setHeader(Constants.HEADER_NX_SCHEMAS, "*").set("value",picdoc.getPath()).execute();
			// get the file content property
			PropertyMap map = docimg.getProperties().getMap("file:content");
			// get the data URL
			String path = map.getString("data");
			return path;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
