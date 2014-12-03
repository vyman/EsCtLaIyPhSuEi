package com.indi.stay.service;

import com.indi.stay.domain.User;

public interface UserService {

	void register(User user);

	boolean sendActivationMail(String to, String from, String activationLink);

	boolean activateUser(String activationcode, int id);

}
