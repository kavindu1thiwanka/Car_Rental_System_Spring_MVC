package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @GetMapping(path = "/user")
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllCustomers());
    }

    @GetMapping(path = "/car")
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,carService.getAllCars());
    }
}
