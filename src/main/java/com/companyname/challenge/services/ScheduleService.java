package com.companyname.challenge.services;

import com.companyname.challenge.dao.ScheduleRepo;
import com.companyname.challenge.entities.ScheduleEntity;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <h1>ScheduleService: wrap restful api class</h1>
*
* Service Class
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepo scheduleRepo;

	/**
	 * Query entity by ID
	 * @param i This is print jod id in db
	 * @return ScheduleEntity Result return for query
	 */
	public ScheduleEntity findSchedule(Long i) {
		return this.scheduleRepo.findById(i).get();
	}

	/**
	 * Save entity into db
	 * @param s This is print entity need to save 
	 * @return ScheduleEntity 
	 */
	public ScheduleEntity save(ScheduleEntity s) {
		return (ScheduleEntity) this.scheduleRepo.save(s);
	}

	/**
	 * Query print job need to perform
	 * @param deliveryTime This is delivery time for query
	 * @return Iterable Can travers result collection
	 */
	public Iterable<ScheduleEntity> findAllByDeliveryTime(Date deliveryTime) {
		return this.scheduleRepo.findAllByDeliveryTime(deliveryTime);
	}
}
