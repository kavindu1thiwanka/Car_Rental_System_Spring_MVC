package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseUtil checkLogin(UserDTO userDTO){
        return new ResponseUtil("OK","Successfully Loaded. :" ,null);
    }

}
