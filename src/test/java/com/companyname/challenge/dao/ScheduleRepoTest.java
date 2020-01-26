package com.companyname.challenge.dao;

import com.companyname.challenge.entities.ScheduleEntity;
import com.companyname.challenge.utils.TestDataHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* <h1>ScheduleRepoTest</h1>
*
* Unit Test Class for repository APIs 
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@SpringBootTest
class ScheduleRepoTest {
	@Autowired
	private ScheduleRepo repo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * generate test data
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ScheduleEntity entity = TestDataHelper.getTestScheduleEntity();
		//save test print job to db from query testing
		this.repo.save(entity);
	}
	/**
	 * Clean test data
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.repo.deleteAll();
	}

	//Test case of findAllByDeliveryTime method of Repository class 
	@Test
	void testFindAllByDeliveryTime() {
		Iterable<ScheduleEntity> it = this.repo.findAllByDeliveryTime(new Date());
		it.forEach(sh -> {
			//the result of test is the print job test data
			assertTrue(TestDataHelper.message.equals(sh.getMessage()));
			assertTrue((sh.isStatus() == true));
		});
	}
}
