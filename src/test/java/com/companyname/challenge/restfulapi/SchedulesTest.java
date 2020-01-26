package com.companyname.challenge.restfulapi;

import com.companyname.challenge.dao.ScheduleRepo;
import com.companyname.challenge.entities.ScheduleEntity;
import com.companyname.challenge.services.ScheduleService;
import com.companyname.challenge.utils.TestDataHelper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

/**
* <h1>SchedulesTest</h1>
*
* Restful Controll Test 
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchedulesTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ScheduleService service;
	
	@Autowired
	private ScheduleRepo repo;
	
	private final String resource = "http://localhost:";

	//clean test envoirnment
	@BeforeEach
	void setUp() throws Exception {
		this.repo.deleteAll();
	}
	
	//clean test envoirnment
	@AfterEach
	void tearDown() throws Exception {
		this.repo.deleteAll();
	}

	/**
	 * GET method test
	 * @throws RestClientException
	 * @throws MalformedURLException
	 */
	@Test
	void testScheduleGet() throws RestClientException, MalformedURLException {
		ScheduleEntity en = TestDataHelper.getTestScheduleEntity();
		String url = "http://localhost:" + this.port + "/schedules/get/";
		//generate a test print job into db
		en = this.service.save(en);
		//send httprequest to restful api via GET method
		ResponseEntity<ScheduleEntity> response = this.restTemplate
				.getForEntity((new URL(url + en.getId().longValue())).toString(), ScheduleEntity.class, new Object[0]);
		//successful result if http status code start with 2
		Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	/**
	 * POST method test
	 * 
	 * @throws URISyntaxException
	 * 
	 */
	@Test
	void testScheduleCreate() throws URISyntaxException {
		// entity need to save
		ScheduleEntity sch = TestDataHelper.getTestScheduleEntity();
		String url = "http://localhost:" + this.port + "/schedules/create";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpMethod method = HttpMethod.POST;
		//set headers and body
		HttpEntity<ScheduleEntity> request = new HttpEntity(sch, (MultiValueMap) headers);
		URI uri = new URI(url);
		//post request to URI
		ResponseEntity<ScheduleEntity> response = this.restTemplate.exchange(uri, method, request,
				ScheduleEntity.class);
		//get id of entity instance of response body
		Long id = ((ScheduleEntity) response.getBody()).getId();
		//extract the test entity from db
		Iterable<ScheduleEntity> it = this.repo.findAll();
		//make sure if the entity is saved
		it.forEach(sh -> Assertions.assertTrue((id == sh.getId())));
	}
}
