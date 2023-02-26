package lk.ijse.easyCar.controller;

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
    @Autowired
    private UserService userService;

    private static final ArrayList<UserDTO> user = new ArrayList<>();

    @PostMapping(path = "/set")
    public void getSetUser(UserDTO dto){
        user.add(dto);
        System.out.println(user);
    }

    @GetMapping
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,userService.getAllUsers());
    }

    @DeleteMapping(params = {"email"})
    public ResponseUtil deleteCustomer(@RequestParam String email){
        userService.deleteUser(email);
        return new ResponseUtil("OK","Successfully Deleted" ,null);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveUser(@RequestPart("userName") String userName,@RequestPart("userAddress") String userAddress, @RequestPart("userNICNo") String userNICNo,
                                 @RequestPart("userContact") int userContact, @RequestPart("email") String email, @RequestPart("role") String role,
                                 @RequestPart("img") MultipartFile file1,@RequestPart("pwd") String pwd) {

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
//            System.out.println(projectPath);
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            UserDTO userDTO = new UserDTO(userName,userAddress,userNICNo,userContact,email,role,"uploads/"+file1.getOriginalFilename(),pwd);
            userService.saveUser(userDTO);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }

        return new ResponseUtil("Ok", "Successfully Saved", null);
    }

}
