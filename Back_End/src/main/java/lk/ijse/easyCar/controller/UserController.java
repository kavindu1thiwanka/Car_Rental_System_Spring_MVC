package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private static final ArrayList<UserDTO> user = new ArrayList<>();
    @Autowired
    private UserService userService;

    @GetMapping(path = "/get")
    public ResponseUtil getOnlineUser() {
        return new ResponseUtil("OK", " ", userService.getUserDetails(user.get(0).getUserEmail()));
    }

    @GetMapping(params = {"userEmail"})
    public ResponseUtil getUserDetails(@RequestParam String userEmail) {
        return new ResponseUtil("OK", " ", userService.getUserDetails(userEmail));
    }

    @PostMapping(path = "/set")
    public void getSetUser(UserDTO dto) {
        user.add(dto);
        System.out.println(user);
    }

    @PostMapping(path = "/rem")
    public void getRemoveUser() {
        user.clear();
    }

    @GetMapping
    public ResponseUtil getAllUsers() {
        return new ResponseUtil("OK", "Successfully Loaded. :", userService.getAllUsers());
    }

    @DeleteMapping(params = {"email"})
    public ResponseUtil deleteUsers(@RequestParam String email) {
        userService.deleteUser(email);
        return new ResponseUtil("OK", "Successfully Deleted", null);
    }

    @PostMapping(path = "/save")
    public ResponseUtil saveCustomer(UserDTO dto) {
        userService.saveUser(dto);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

}
