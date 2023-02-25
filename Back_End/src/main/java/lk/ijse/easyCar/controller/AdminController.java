package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.service.BookingService;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @GetMapping(path = "/u")
    public ResponseUtil getAllUsers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllUsersCount());
    }
    @GetMapping(path = "/d")
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllDriversCount());
    }
    @GetMapping(path = "/b")
    public ResponseUtil getBookingForDay(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,bookingService.getAllBookingForDayCount());
    }
}
