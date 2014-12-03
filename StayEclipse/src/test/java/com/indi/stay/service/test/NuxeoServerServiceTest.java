package com.indi.stay.service.test;

import java.io.File;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.indi.stay.service.NuxeoServerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class NuxeoServerServiceTest {
	
	@Autowired
	private NuxeoServerService nuxeoServerService;
	
	@Test
	public void persistImageAndReturnPath(){
		final String TEST_FILE = "C:/Users/Vyman.Hm/Desktop/Koala.jpg";
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		MockMultipartHttpServletRequest mockMultipartHttpServletRequest = (MockMultipartHttpServletRequest)request;
		CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) mockMultipartHttpServletRequest.getFile(TEST_FILE);
		
		String path= nuxeoServerService.persistImageAndReturnPath(commonsMultipartFile);
		System.out.println(path);
	}

}
