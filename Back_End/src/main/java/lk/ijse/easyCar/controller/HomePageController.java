package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomePageController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public ResponseUtil getAll() {
        return new ResponseUtil("OK", "Successfully Loaded. :", userService.getAll());
    }

}
