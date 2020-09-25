package org.tyaa.examples.java.springboot.rmi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.tyaa.examples.java.springboot.rmi.common.ICabBookingService;

@SpringBootApplication
public class RmiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmiServerApplication.class, args);
	}

	@Bean
	ICabBookingService bookingService() {
		return new CabBookingServiceImpl();
	}

	@Bean
	RmiServiceExporter exporter(ICabBookingService implementation) {

		// Expose a service via RMI. Remote object URL is:
		// rmi://<HOST>:<PORT>/<SERVICE_NAME>
		// 1099 is the default port

		Class<ICabBookingService> serviceInterface = ICabBookingService.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(implementation);
		// exporter.setServiceName(serviceInterface.getSimpleName());
		exporter.setServiceName("CabBooking");
		exporter.setRegistryPort(1099);
		return exporter;
	}
}
