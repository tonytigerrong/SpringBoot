package com.companyname.challenge;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
* <h1>Back end Challenge Solution</h1>
*
* Interview hand-on coding for iqvia.com
* 
* @author  Jianzhong Rong
* @version 1.0
* @since   2020-01-26
*/
@SpringBootApplication
@EnableScheduling
public class BackendChallengeApplication {
	
	/**
	 * JVM and App time zone set up
	 * 
	 */
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-4"));
		System.setProperty("user.timezone", "GMT-4");
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendChallengeApplication.class, args);
	}
}
