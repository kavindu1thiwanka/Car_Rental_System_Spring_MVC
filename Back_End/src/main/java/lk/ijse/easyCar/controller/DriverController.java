package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.BookingService;
import lk.ijse.easyCar.service.UserService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    private static final ArrayList<UserDTO> driver = new ArrayList<>();
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/set")
    public void getSetUser(UserDTO dto) {
        driver.add(dto);
    }

    @PostMapping(path = "/rem")
    public void getRemoveDriver() {
        driver.clear();
    }

    @GetMapping
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil("OK", "Successfully Loaded. :", userService.getAllDrivers());
    }

    @GetMapping(path = "/get")
    public ResponseUtil getOnlineUser() {
        return new ResponseUtil("OK", " ", userService.getDriverDetails(driver.get(0).getUserEmail()));
    }

    @GetMapping(params = {"driverEmail"})
    public ResponseUtil getDriverWorkShedule(@RequestParam String driverEmail) {
        return new ResponseUtil("OK", "Successfully Loaded. :", bookingService.getDriverWorkShedule(driverEmail));
    }

    @GetMapping(path = "/available")
    public ResponseUtil getAllAvailableDrivers() {
        return new ResponseUtil("OK", "Successfully Loaded. :", userService.getAllAvailableDrivers());
    }

    @DeleteMapping(params = {"email"})
    public ResponseUtil deleteDriver(@RequestParam String email) {
        userService.deleteDriver(email);
        return new ResponseUtil("OK", "Successfully Deleted", null);
    }
}
