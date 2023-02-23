package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.service.DriverService;
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
    private CarService carService;
    @Autowired
    private DriverService driverService;

    @GetMapping(path = "/user")
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllCustomers());
    }

    @GetMapping(path = "/car")
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,carService.getAllCars());
    }

    @GetMapping(path = "/driver")
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,driverService.getAllDrivers());
    }

}
