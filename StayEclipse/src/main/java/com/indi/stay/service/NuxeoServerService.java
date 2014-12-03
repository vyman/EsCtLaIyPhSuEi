package com.indi.stay.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface NuxeoServerService {

	String persistImageAndReturnPath(CommonsMultipartFile commonsMultipartFile);

}
