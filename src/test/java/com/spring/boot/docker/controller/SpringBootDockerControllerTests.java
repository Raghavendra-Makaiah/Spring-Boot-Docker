package com.spring.boot.docker.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.docker.SpringBootDockerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = SpringBootDockerApplication.class)
@DirtiesContext
public class SpringBootDockerControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testHomePage() throws Exception {
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:" + this.port + "/springbootdocker/", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	public void testHomePageNotFound() throws Exception {
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:" + this.port + "/", String.class);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

}
