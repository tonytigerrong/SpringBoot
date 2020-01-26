package com.companyname.challenge.services;

import com.companyname.challenge.dao.ScheduleRepo;
import com.companyname.challenge.entities.ScheduleEntity;
import com.companyname.challenge.utils.TestDataHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* <h1>ScheduleServiceTest</h1>
*
* Unit Test Class for Service class 
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@SpringBootTest
class ScheduleServiceTest {
	@Autowired
	private ScheduleService service;
	@Autowired
	private ScheduleRepo repo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	/**
	 * Clean test data
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.repo.deleteAll();
	}

	@Test
	void testFindSchedule() {
	}

	/**
	 * Unit test case for Service class save method
	 */
	@Test
	void testSave() {
		ScheduleEntity entity1 = TestDataHelper.getTestScheduleEntity();
		this.service.save(entity1);
		this.service.findAllByDeliveryTime(entity1.getDeliveryTime()).forEach(sh -> {
			//to see if the entity save to db successfully
			assertTrue(sh.getMessage().equals(entity1.getMessage()));
			assertTrue((sh.getDeliveryTime().compareTo(entity1.getDeliveryTime()) == 0));
		});
	}

	@Test
	void testFindAllByDeliveryTime() {
	}
}
