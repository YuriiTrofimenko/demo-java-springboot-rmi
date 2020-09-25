package org.tyaa.examples.java.springboot.rmi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.tyaa.examples.java.springboot.rmi.common.Booking;
import org.tyaa.examples.java.springboot.rmi.common.BookingException;
import org.tyaa.examples.java.springboot.rmi.common.ICabBookingService;

@SpringBootApplication
public class RmiClientApplication {

	public static void main(String[] args) {
		ICabBookingService service =
			SpringApplication
				.run(RmiClientApplication.class, args)
				.getBean(ICabBookingService.class);
		Booking bookingOutcome = null;
		try {
			bookingOutcome = service.bookRide("13 Seagate Blvd, Key Largo, FL 33037");
			System.out.println("Booking outcome: " + bookingOutcome);
		} catch (BookingException e) {
			System.err.println(e.getMessage());
		}
	}

	@Bean
	RmiProxyFactoryBean service() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/CabBooking");
		rmiProxyFactory.setServiceInterface(ICabBookingService.class);
		return rmiProxyFactory;
	}
}
