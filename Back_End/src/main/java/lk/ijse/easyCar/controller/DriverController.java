package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.DriverDTO;
import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private UserService userService;

    private static final ArrayList<DriverDTO> user = new ArrayList<>();

    @PostMapping(path = "/set")
    public void getSetDriver(DriverDTO dto){
        user.add(dto);
        System.out.println(user);
    }

    @PostMapping(path = "/rem")
    public void getRemoveDriver(){
        user.clear();
    }

    @GetMapping
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllDrivers());
    }

    @DeleteMapping(params = {"email"})
    public ResponseUtil deleteDriver(@RequestParam String email){
        userService.deleteDriver(email);
        return new ResponseUtil("OK","Successfully Deleted" ,null);
    }
}
