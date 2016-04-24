package com.rangaraj.sample.service;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	@Transactional
	long addUser(final String userId, final String welcomeMessage);
}
