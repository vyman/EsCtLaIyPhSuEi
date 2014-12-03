package com.indi.stay.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indi.stay.domain.Role;
import com.indi.stay.domain.User;
import com.indi.stay.domain.UserRole;
import com.indi.stay.service.RoleService;
import com.indi.stay.service.UserRoleService;
import com.indi.stay.service.UserService;

@Controller
@RequestMapping(value="/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET)
    public String displayRigisterPage(Model model)
    {
        model.addAttribute("newUser", new User());
        return "userRegister";
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,HttpServletRequest httpServletRequest) {
			user.setEnabled(false);
			user.setDateOfBirth(new Date());
			user.setActivationCode(RandomStringUtils.randomAlphabetic(50));
			
			userService.register(user);
			Role role=new Role();
			role.setRole("testRole");
			roleService.register(role);
			UserRole userRole=new UserRole();
			userRole.setUser(user);
			userRole.setRole(roleService.findRole("testRole"));
			
			userRoleService.persist(userRole);
			StringBuilder activationLink = new StringBuilder("http://").append(messageSource.getMessage("application.domain", null, null, null))
					.append("/")
					.append(httpServletRequest.getContextPath())
					.append("/activateAccount").append("?activationcode=").append(user.getActivationCode()).append("&").append("id=").append(user.getId());
			userService.sendActivationMail(user.getEmail(), messageSource.getMessage("mail.from", null,null,null), activationLink.toString());
			model.addAttribute("message","suc" );
			return "registrationsuccess";

	}
	
	@RequestMapping(value = "/activateAccount", method = RequestMethod.GET)
	public String activateAccount(Model model,@Param String activationcode,@Param int id){	
		boolean isSuccess = userService.activateUser(activationcode, id);
		if(isSuccess == true){
			model.addAttribute("message", messageSource.getMessage("register.activation.success", null, null, null) );
		}else{
			model.addAttribute("message", messageSource.getMessage("register.activation.failure", null, null, null) );
		}
		
		return "registrationsuccess";
	}

}
