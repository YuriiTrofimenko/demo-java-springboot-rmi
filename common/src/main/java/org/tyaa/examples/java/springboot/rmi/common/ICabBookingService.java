package org.tyaa.examples.java.springboot.rmi.common;

public interface ICabBookingService {
    Booking bookRide(String pickUpLocation) throws BookingException;
}
