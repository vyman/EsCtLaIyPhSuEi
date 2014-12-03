package com.indi.stay.dam;

import java.io.File;

import org.nuxeo.ecm.automation.client.Constants;
import org.nuxeo.ecm.automation.client.Session;
import org.nuxeo.ecm.automation.client.jaxrs.impl.HttpAutomationClient;
import org.nuxeo.ecm.automation.client.model.Document;
import org.nuxeo.ecm.automation.client.model.FileBlob;
import org.nuxeo.ecm.automation.client.model.PropertyMap;

public class NuxeoTest {
	
	public static void main(String[] args) throws Exception {
	    HttpAutomationClient client = new HttpAutomationClient(
	           "http://localhost:8080/nuxeo/site/automation");
	 
	    Session session = client.getSession("Administrator", "Administrator");
	 // get the root
	    Document root = (Document) session.newRequest("Document.Fetch").set(
	            "value", "/").execute();
	    // create a file document
	    Document doc=(Document) session.newRequest("Document.Create").setInput(root).set("type", "Folder").set(
	            "name", "myfile_xyz").set("properties", "dc:title=My File_XYZ").execute();
	    
	    Document picdoc=(Document) session.newRequest("Document.Create").setInput(doc).set("type", "Picture").set(
	            "name", "myfile_xyzv").set("properties", "dc:title=My_Pic").execute();
	   
	    File file = new File("C:/Users/Vyman.Hm/Desktop/Koala.jpg");
	    FileBlob fb = new FileBlob(file);
	    fb.setMimeType("image/jpeg");
	    
	    session.newRequest("Blob.Attach").setHeader(
	            Constants.HEADER_NX_VOIDOP, "true").setInput(fb)
	            .set("document", picdoc).execute();
	    
//	    Document picdoc1=(Document) session.newRequest("Document.Create").setInput(doc).set("type", "Picture").set(
//	            "name", "myfile_messi").set("properties", "dc:title=My_Pic_Messi").execute();
//	    
//	    File file1 = new File("C:/Users/Vyman.Hm/Desktop/messi-y-cristiano-331.jpg");
//	    FileBlob fb1 = new FileBlob(file1);
//	    fb1.setMimeType("image/jpeg");
//	    
//	    session.newRequest("Blob.Attach").setHeader(
//	            Constants.HEADER_NX_VOIDOP, "true").setInput(fb1)
//	            .set("document", picdoc1).execute();
	    
	    Document docimg = (Document) session.newRequest("Document.Fetch").setHeader(Constants.HEADER_NX_SCHEMAS, "*").set("value",picdoc.getPath()).execute();
	    		// get the file content property
	    		PropertyMap map = docimg.getProperties().getMap("file:content");
	    		// get the data URL
	    		String path = map.getString("data");;

	    		session.newRequest("Document.Delete").setInput(doc).execute();
//	     System.out.println("path = "+path);
//	    // download the file from its remote location
//	    fb = (FileBlob) session.getFile(path);
//	    // ... do something with the file
//	    // at the end delete the temporary file
//	    fb.getFile().delete();
	    client.shutdown();
	}

}
