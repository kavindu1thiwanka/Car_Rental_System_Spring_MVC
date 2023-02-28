package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.BookingDTO;
import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.entity.Booking;

import java.util.ArrayList;

public interface BookingService {
    Object getAllBookingForDayCount();

    ArrayList<BookingDTO> getAllBookingDetails();

    void placeBooking(Booking dto);
}
