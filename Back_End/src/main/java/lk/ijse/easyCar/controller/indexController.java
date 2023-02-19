package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.service.HomeService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class indexController {

    @Autowired
    HomeService homeService;

//    @PostMapping(path = "login")
//    public ResponseUtil checkLogin(){
//        return new ResponseUtil("OK",null,homeService.checkLogin());
//    }

    @PostMapping(path = "login")
    public void checkLogin(){
        System.out.println("hari");
    }

    @GetMapping
    public void loadLuxuryCars(){

    }

    @GetMapping
    public void loadPremiumCars(){

    }

    @GetMapping
    public void loadGeneralCars(){

    }
}
