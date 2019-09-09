/**
 * 
 */
package com.boot.springmvc;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * @author sourav
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.boot.springmvc.AppController#greeting(org.springframework.ui.Model)}.
	 * @throws MalformedURLException 
	 * @throws RestClientException 
	 */
	@Test
	final void testGreeting() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
		System.err.println("response.getBody()"+response.getStatusCodeValue());
		Assertions.assertEquals(200, response.getStatusCodeValue());		
	}

	
	

	/**
	 * Test method for
	 * {@link com.boot.springmvc.AppController#searchBook(com.boot.springmvc.model.Book, org.springframework.ui.Model)}.
	 * @throws MalformedURLException 
	 * @throws RestClientException 
	 */
	@Test
	final void testSearchBook() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/searchbook").toString(), String.class);
		System.err.println("response.getBody()"+response.getStatusCodeValue());
		Assertions.assertEquals(405, response.getStatusCodeValue());	
	}

	/**
	 * Test method for
	 * {@link com.boot.springmvc.AppController#searchSubject(com.boot.springmvc.model.Subject, org.springframework.ui.Model)}.
	 * @throws MalformedURLException 
	 * @throws RestClientException 
	 */
	@Test
	final void testSearchSubject() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate
				.getForEntity(new URL("http://localhost:" + port + "/searchsubject").toString(), String.class);
		System.err.println("response.getBody()"+response.getStatusCodeValue());
		Assertions.assertEquals(405, response.getStatusCodeValue());	
	}

	
}
