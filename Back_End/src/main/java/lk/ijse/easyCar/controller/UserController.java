package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.AllUserDTO;
import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO dto) {
        userService.updateUser(dto);
        return new ResponseUtil("OK", "Successfully Updated. : " + dto.getUserName(), null);
    }

    @PutMapping(path = "/all")
    public ResponseUtil updateUserPwd(@RequestBody AllUserDTO dto) {
        userService.updateUserPwd(dto);
        return new ResponseUtil("OK", "Password Successfully Updated..!", null);
    }

    @PutMapping(path = "/saveImg", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveImage(UserDTO userDTO, @RequestPart("imgFile") MultipartFile file1) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            userDTO.setImgUrl("uploads/" + file1.getOriginalFilename());
            userService.updateUser(userDTO);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }
}
