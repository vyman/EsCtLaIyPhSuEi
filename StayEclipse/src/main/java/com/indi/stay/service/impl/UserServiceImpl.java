package com.indi.stay.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.indi.stay.domain.User;
import com.indi.stay.repo.UserDao;
import com.indi.stay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Override
	public void register(User user) {
		userDao.register(user);
	}
	
	@Override
	public boolean sendActivationMail(String to,String from,String activationLink) {
		boolean isSendingSuccess = true;
		  SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(to);
	        msg.setFrom(from);
	        msg.setSubject("HRD Stay:Activate your Account");
	        Map<String,Object> model = new HashMap<String,Object>();
            model.put("activationlink", activationLink);
	        String text = VelocityEngineUtils.mergeTemplateIntoString(
	                velocityEngine, "emailActivation.vm", model);
	        msg.setText(text);
	        try{
	            this.mailSender.send(msg);
	        }
	        catch(MailException ex) {
	            System.err.println(ex.getMessage());    
	            isSendingSuccess = false;
	        }
		return isSendingSuccess;
	}
	
	@Override
	public boolean activateUser(String activationcode,int id) {
		boolean isActivationSuccess = false;
		User user = userDao.findById(id);
		if(user!=null && activationcode!=null && !("".equals(activationcode)) && user.getActivationCode()!=null && user.getActivationCode().equals(activationcode) ){
			user.setEnabled(true);
			userDao.merge(user);
			isActivationSuccess = true;
		}
		return isActivationSuccess;
	}
}
