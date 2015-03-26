package com.indi.stay.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class StayIdAndRoomImages {

	private Integer stayId;
	private List<MultipartFile> files;
	public Integer getStayId() {
		return stayId;
	}
	public void setStayId(Integer stayId) {
		this.stayId = stayId;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
	
}
