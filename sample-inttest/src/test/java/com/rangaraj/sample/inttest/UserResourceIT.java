package com.rangaraj.sample.inttest;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.rangaraj.sample.rest.model.CreateUserRequest;
import com.rangaraj.sample.rest.model.CreateUserResponse;

/**
 * Integration test for User API
 */
@ContextConfiguration(locations = { "classpath*:test-application-context.xml" })
public class UserResourceIT extends AbstractTestNGSpringContextTests {

	@Autowired
	private DataSource dataSource;

	private static final String serviceUrl = "http://localhost:8080/sample/rest/user";

	@Test(description = "Test case for adding user happy path: http status response: 200 OK")
	public void testAddUser() {
		Reporter.log("testAddUser, proper request test start");
		final String userId = "testuser1241";
		final String welcomeMessage = "first user message";
		WebClient webClient = createWebClient();
		Response r = webClient.path("").accept("application/json").post(createUserRequest(userId, welcomeMessage));
		System.out.println("r.getStatus()---->" + r.getStatus());
		assertEquals(new Integer(200), new Integer(r.getStatus()));
		validateUserInDB(userId, welcomeMessage);
		Reporter.log("testAddUser, proper request test end");
	}

	private void validateUserInDB(final String userId, final String welcomeMessage) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<CreateUserResponse> createUserResponsesDB = jdbcTemplate
				.query("SELECT USER_ID, WELCOME_MESSAGE FROM PUBLIC.USER", new RowMapper<CreateUserResponse>() {

					@Override
					public CreateUserResponse mapRow(ResultSet rs, int i) throws SQLException {
						CreateUserResponse createUserResponseDB = new CreateUserResponse();
						createUserResponseDB.setUserId(rs.getString("USER_ID"));
						createUserResponseDB.setMessage(rs.getString("WELCOME_MESSAGE"));
						return createUserResponseDB;
					}
				});

		final List<CreateUserResponse> createUserResponsesFinalDB = createUserResponsesDB.stream()
				.filter(createUserResponseDB -> createUserResponseDB.getUserId().equalsIgnoreCase(userId))
				.collect(Collectors.toList());
		
		if (!createUserResponsesFinalDB.isEmpty()) {
			CreateUserResponse createUserResponseDB = createUserResponsesFinalDB.get(0);
			assertEquals(createUserResponseDB.getUserId(), userId);
			assertEquals(createUserResponseDB.getMessage(), welcomeMessage);
		} else {
			fail("User POST service did not insert user record into database ");
			Reporter.log("User POST service did not insert user record into database ");
		}

	}

	private CreateUserRequest createUserRequest(final String userId, final String welcomeMessage) {
		CreateUserRequest createUserRequest = new CreateUserRequest();
		createUserRequest.setUserId(userId);
		createUserRequest.setWelcomeMessage(welcomeMessage);
		return createUserRequest;
	}

	private WebClient createWebClient() {
		final List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJaxbJsonProvider());
		WebClient webClient = WebClient.create(serviceUrl, providers);
		webClient.header("Content-Type", "application/json");
		webClient.header("Accept-Language", "en-US,en;q=0.8,ru;q=0.6,es;q=0.4");
		return webClient;
	}
}
