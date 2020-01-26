package com.companyname.challenge.dao;

import com.companyname.challenge.entities.ScheduleEntity;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
* <h1>ScheduleRepo</h1>
*
* <b>extends</b> from CrudRepository interface to handle CRUD operations via JPA
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@Repository
public interface ScheduleRepo extends CrudRepository<ScheduleEntity, Long> {
	//query jobs which have delivery time earlier or equal the passed in time and status is true(unprinted)
	@Query("select a from ScheduleEntity a where a.deliveryTime <= :deliveryTime and a.status = TRUE")
	Iterable<ScheduleEntity> findAllByDeliveryTime(Date deliveryTime);
}
