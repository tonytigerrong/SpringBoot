package com.companyname.challenge.components;

import com.companyname.challenge.entities.ScheduleEntity;
import com.companyname.challenge.services.ScheduleService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* <h1>Printing action perform in the class</h1>
*
* <b>Schedule</b> job perform class
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@Component
public class Printer {
	@Autowired
	ScheduleService scheduleService;

	@Scheduled(fixedRate = 10000L)
	public void print() {
		Date date = new Date();
		//extract print jobs which deliver time earlier or equal current time
		Iterable<ScheduleEntity> it = this.scheduleService.findAllByDeliveryTime(date);
		//traverse jobs iterable and print on console
		it.forEach(sh -> {
			System.out.println("Printing msg: " + sh.toString());
			sh.setStatus(false);
			this.scheduleService.save(sh);
		});
	}
}
