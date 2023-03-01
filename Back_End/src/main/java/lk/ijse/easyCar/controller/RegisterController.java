package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.AllUserDTO;
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

    @PostMapping(path = "/user")
    public ResponseUtil registerUser(@RequestBody AllUserDTO dto) {
        service.saveToAllUser(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }
}
