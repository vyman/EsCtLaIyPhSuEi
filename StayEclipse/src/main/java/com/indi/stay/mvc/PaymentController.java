package com.indi.stay.mvc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Payment")
public class PaymentController {

	@RequestMapping(method=RequestMethod.GET)
	public String displayPaymentPage(Model model,HttpServletRequest request, 
	        HttpServletResponse response)
	{

		String merchant_key="JBZaLc";
		String salt="GQs7yium";
		String action1 ="";
		String base_url="https://test.payu.in";
		int error=0;
		String hashString="";
		
	 

		
		Enumeration<String> paramNames = request.getParameterNames();
		Map<String,String> params= new HashMap<String,String>();
	    	while(paramNames.hasMoreElements()) 
		{
	      		String paramName = (String)paramNames.nextElement();
	      
	      		String paramValue = request.getParameter(paramName);

			params.put(paramName,paramValue);
		}
		String txnid ="";
		
		if(empty(params.get("txnid"))){
			Random rand = new Random();
			String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
			txnid=hashCal("SHA-256",rndm).substring(0,20);
		}
		else
		{
		txnid=params.get("txnid");
		}
	    
		String udf2 = txnid;
		String txn="abcd";
		String hash="";
		String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
		
		params.put("key",merchant_key);
		params.put("txnid",txnid);
		params.put("amount","200");
		params.put("firstname","vyman");
		params.put("email","test.t@gmail.com");
		params.put("phone","7899653947");
		params.put("productinfo","test");
		params.put("surl","http://localhost:7001/StayEclipse/Payment/Success");
		params.put("furl","http://localhost:7001/StayEclipse/Payment/Failure");
		params.put("service_provider","payu_paisa");
		if(empty(params.get("hash")) && params.size()>0)
		{
			if( empty(params.get("key"))
				|| empty(params.get("txnid"))
				|| empty(params.get("amount"))
				|| empty(params.get("firstname"))
				|| empty(params.get("email"))
				|| empty(params.get("phone"))
				|| empty(params.get("productinfo"))
				|| empty(params.get("surl"))
				|| empty(params.get("furl"))
				|| empty(params.get("service_provider"))
					)
			{		
				error=1;
			}
			else{
				String[] hashVarSeq=hashSequence.split("\\|");
				
				for(String part : hashVarSeq)
				{
					hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
					hashString=hashString.concat("|");
				}
				hashString=hashString.concat(salt);
				hash=hashCal("SHA-512",hashString);
				action1=base_url.concat("/_payment");
			}
		}
		else if(!empty(params.get("hash")))
		{
			hash=params.get("hash");
			action1=base_url.concat("/_payment");
		}

		model.addAttribute("merchant_key",merchant_key );
		model.addAttribute("hash",hash );
		model.addAttribute("txnid", txnid);
		model.addAttribute("firstName", "vyman");
		return "payuform";
	}

	@RequestMapping(method=RequestMethod.GET, value="/Success")
	public String displayPaymentSuccessPage(Model model)
	{
		return "success";
	}

	@RequestMapping(method=RequestMethod.GET,value="/Failure")
	public String displayPaymentFailurePage(Model model)
	{
		return "failure";
	}

	
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();



			for (int i=0;i<messageDigest.length;i++) {
				String hex=Integer.toHexString(0xFF & messageDigest[i]);
				if(hex.length()==1) hexString.append("0");
				hexString.append(hex);
			}

		}catch(NoSuchAlgorithmException nsae){ }

		return hexString.toString();
	}
	
	public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
}
