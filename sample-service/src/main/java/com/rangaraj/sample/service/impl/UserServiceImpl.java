package com.rangaraj.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangaraj.sample.dbmodel.User;
import com.rangaraj.sample.jpa.UserRepository;
import com.rangaraj.sample.service.UserService;

/**
 * This is the business service implementation for User entity
 * @author rangarajthangadurai
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Adds user information into database
	 * 
	 * @param userId the user id credential
	 * @param welcomeMessage the welcome message for the user
	 * @return the db user id for newly created user
	 */
	public long addUser(final String userId, final String welcomeMessage) {
		User user = new User();
		user.setUserId(userId);
		user.setWelcomeMessage(welcomeMessage);
		final User savedUser = userRepository.save(user);

		return savedUser.getId();
	}
}
