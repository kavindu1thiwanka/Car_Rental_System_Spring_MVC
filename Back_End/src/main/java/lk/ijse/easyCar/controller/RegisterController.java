package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reg")
public class RegisterController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseUtil registerUser(@ModelAttribute UserDTO dto){
        service.registerUser(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }
}
