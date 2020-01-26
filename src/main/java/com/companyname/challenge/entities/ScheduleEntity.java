package com.companyname.challenge.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* <h1>ScheduleEntity</h1>
*
* Print job entity
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@Entity
public class ScheduleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deliveryTime;
	private boolean status = true;

	/**
	 * status (true: need print; false: printted already)
	 * @return
	 */
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String toString() {
		return "[message: " + getMessage() + "; deliveryTime: " + getDeliveryTime() + ";]";
	}
}
