package com.companyname.challenge.utils;

import com.companyname.challenge.entities.ScheduleEntity;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
* <h1>TestDataHelper</h1>
*
* Utils Class: Unit test data preparation 
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
public class TestDataHelper {
	public static String message = "print this message please!";

	public static ScheduleEntity getTestScheduleEntity() {
		//later 5 hours from current time
		LocalDateTime time = LocalDateTime.now().minusHours(5L);
		ScheduleEntity entity = new ScheduleEntity();
		entity.setMessage(message);
		//set time zone to GMT-4(AST)
		entity.setDeliveryTime(Date.from(time.toInstant(ZoneOffset.ofHours(-4))));
		return entity;
	}
}
