package com.rangaraj.sample.restimpl.resource.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rangaraj.sample.rest.model.CreateUserRequest;
import com.rangaraj.sample.rest.model.CreateUserResponse;
import com.rangaraj.sample.rest.resource.UserResource;
import com.rangaraj.sample.service.UserService;

/**
 * This is the implementation class for REST service UserResource
 * @author rangarajthangadurai
 *
 */
@Component
public class UserResourceImpl implements UserResource {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

	/**
	 * POST User 
	 * 
	 * @Param createUserRequest the instance of CreateUserRequest
	 * @throws Exception in case of any issue in creating user
	 * @return the PostUserResponse containing the db user id for newly created user
	 */
	@Override
	public PostUserResponse postUser(CreateUserRequest createUserRequest) throws Exception {
		logger.info("{}.postUser(), createUserRequest: {}", getClass().getName(), createUserRequest);
		CreateUserResponse response = new CreateUserResponse();
		final String userId = createUserRequest.getUserId();
		final String welcomeMessage = createUserRequest.getWelcomeMessage();
		final long dbUserId = userService.addUser(userId, welcomeMessage);

		response.setDbUserId(new Long(dbUserId).toString());
		response.setUserId(userId);
		response.setMessage(welcomeMessage);
		return UserResource.PostUserResponse.withJsonOK(response);
	}

}
