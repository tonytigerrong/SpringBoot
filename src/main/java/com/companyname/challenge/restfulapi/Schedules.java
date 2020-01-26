package com.companyname.challenge.restfulapi;

import com.companyname.challenge.entities.ScheduleEntity;
import com.companyname.challenge.services.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
* <h1>Schedules: restful api controller class</h1>
*
* restful api which wrap CRUD operations to interface
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@RestController
public class Schedules {
	@Autowired
	private ScheduleService scheduleService;

	/**
	 * Method is GET
	 * @param id This path parameter, print jod id we need query for
	 * @return ScheduleEntity
	 */
	@RequestMapping(path = { "schedules/get/{id}" }, method = { RequestMethod.GET })
	public ScheduleEntity scheduleGet(@PathVariable("id") Long id) {
		return this.scheduleService.findSchedule(id);
	}

	/**
	 * Method is POST
	 * @param s This body parameter of post request, need to save to db
	 * @return ScheduleEntity
	 */
	@RequestMapping(value = { "schedules/create" }, method = { RequestMethod.POST }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<ScheduleEntity> scheduleCreate(@RequestBody ScheduleEntity s) throws JsonProcessingException {
		this.scheduleService.save(s);
		//set status to 202 accepted 
		return ResponseEntity.accepted().body(s);
	}
}
