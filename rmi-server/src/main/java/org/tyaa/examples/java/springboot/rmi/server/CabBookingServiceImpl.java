package org.tyaa.examples.java.springboot.rmi.server;

import org.tyaa.examples.java.springboot.rmi.common.Booking;
import org.tyaa.examples.java.springboot.rmi.common.BookingException;
import org.tyaa.examples.java.springboot.rmi.common.ICabBookingService;

import static java.lang.StrictMath.random;
import static java.util.UUID.randomUUID;

public class CabBookingServiceImpl implements ICabBookingService {
    @Override public Booking bookRide(String pickUpLocation) throws BookingException {
        final Double fakeBookingConditionValue = random();
        final Boolean fakeBookingConditionRule = (fakeBookingConditionValue >= 0.3);
        System.out.println("Server: fake booking condition value is " + fakeBookingConditionValue);
        if (!fakeBookingConditionRule) throw new BookingException("Cab unavailable");
        return new Booking(randomUUID().toString());
    }
}
