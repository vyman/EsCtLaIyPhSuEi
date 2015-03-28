package com.indi.stay.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.indi.stay.domain.Facility;
import com.indi.stay.domain.StaySuite;
import com.indi.stay.domain.StaySuitePhotos;
import com.indi.stay.domain.SuiteType;
import com.indi.stay.service.FacilityService;
import com.indi.stay.service.NuxeoServerService;
import com.indi.stay.service.StaySuitePhotosService;
import com.indi.stay.service.StaySuiteService;
import com.indi.stay.service.SuiteTypeService;
import com.indi.stay.util.BimpDeleteFiles;
import com.indi.stay.util.BimpPostFile;
import com.indi.stay.util.BimpPostFileList;

@Controller
@RequestMapping(value="/Bimp")
public class BimpController {
	
	@Autowired
	private SuiteTypeService suiteTypeService;

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private StaySuiteService staySuiteService;
	
	
	@Autowired
	private StaySuitePhotosService staySuitePhotosService;
	
	@Autowired
	private NuxeoServerService nuxeoServerService;

	@RequestMapping(method=RequestMethod.GET)
	public String displayBookingPage(Model model)
	{
		List<SuiteType> suiteTypes= suiteTypeService.findAllOrderedByName();
		List<Facility> facilities= facilityService.findAllOrderedByName();
		model.addAttribute("newRoom", new StaySuite());
		model.addAttribute("facilities", facilities);
		model.addAttribute("suiteTypes", suiteTypes);
		model.addAttribute("stayId", 1000);
		return "bimp";
	}


	@RequestMapping(method=RequestMethod.HEAD)
	@ResponseStatus(value = HttpStatus.OK)
	public void headResponse(Model model)
	{
		System.out.println("head method to set server status");
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/server/php")
	@ResponseBody
	public String handleGetServer(Model model)
	{
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("test.jpg", true);
		
		BimpDeleteFiles bimpDeleteFiles =new BimpDeleteFiles();
		bimpDeleteFiles.setFiles(map);
		Gson gson= new Gson();
		String json=gson.toJson(bimpDeleteFiles);
		System.out.println("delete method");
		return json;
	}

	@RequestMapping(method=RequestMethod.POST,value="/server/php")
	@ResponseBody
	public String handleBooking(Model model,@RequestParam("staySuiteId") Integer staySuiteId,HttpServletRequest request)
	{
		BimpPostFileList bimpPostFileList= new BimpPostFileList();
		
		StaySuite staySuite= staySuiteService.findById(staySuiteId);
		
		StaySuitePhotos staySuitePhotos = new StaySuitePhotos();
		
		BimpPostFile bimpPostFile= new BimpPostFile();
		
		List<BimpPostFile> listbList= new ArrayList<BimpPostFile>();
		
		
		try
	    {
	        //List<Part> formData = new ArrayList(request.getParts());
	        //Part part = formData.get(0);
	        //Part part = request.getPart("file1");
	        //String parameterName = part.getName();
	        //logger.info("STORC IMAGES - " + parameterName);
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        String staySuitePhotoImgPath=null;
	        Set set = multipartRequest.getFileMap().entrySet(); 
	        Iterator i = set.iterator(); 
	        while(i.hasNext()) { 
	            Map.Entry me = (Map.Entry)i.next(); 
	            String fileName = (String)me.getKey();
	            MultipartFile multipartFile = (MultipartFile)me.getValue();
	            System.out.println("Original fileName - " + multipartFile.getOriginalFilename());
	            System.out.println("fileName - " + fileName);
//	            writeToDisk(fileName, multipartFile);
	            staySuitePhotoImgPath=nuxeoServerService.persistImageAndReturnPath((CommonsMultipartFile) multipartFile);
	            staySuitePhotos.setImagepath(staySuitePhotoImgPath);
	            if(staySuite.getSuiteProfilePic()==null){
	            	staySuite.setSuiteProfilePic(staySuitePhotoImgPath);
	            	staySuite=staySuiteService.merge(staySuite);
	            }
	            
	            staySuitePhotos.setStaysuite(staySuite);
	            staySuitePhotosService.merge(staySuitePhotos);
	            
	            boolean noError=true;
	    		if(noError){
	    		bimpPostFile.setName(fileName);
	    		bimpPostFile.setSize(multipartFile.getSize());
	    		bimpPostFile.setUrl(staySuitePhotoImgPath);
	    		bimpPostFile.setThumbnailUrl(staySuitePhotoImgPath);
	    		bimpPostFile.setDeleteUrl("http://localhost:7001/StayEclipse/Bimp/server/php/"+staySuitePhotos.getId());
	    		bimpPostFile.setDeleteType("DELETE");
	    		}else{
	    			bimpPostFile.setName("test");
	    			bimpPostFile.setSize(200);
	    			bimpPostFile.setError("test error");
	    		}
	        } 
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	    }
		
		listbList.add(bimpPostFile);
		bimpPostFileList.setFiles(listbList);
		Gson gson= new Gson();
		String json=gson.toJson(bimpPostFileList);
		return json;
	}	

}







