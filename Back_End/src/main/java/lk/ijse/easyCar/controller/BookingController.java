package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.entity.Booking;
import lk.ijse.easyCar.service.BookingService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseUtil placeBooking(@RequestBody Booking dto){
        bookingService.placeBooking(dto);
        return new ResponseUtil("OK","Reservation Successful.!",null);
    }

    @GetMapping
    public ResponseUtil getAllBookingDetails(){
        return new ResponseUtil("OK","Successful",bookingService.getAllBookingDetails());
    }

}
