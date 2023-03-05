package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class VehicleController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseUtil getAllCars() {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getAllCars());
    }

    @GetMapping(params = {"id"})
    public ResponseUtil getVehicleDetailsByID(@RequestParam String id) {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getVehicleDetailsByID(id));
    }

    @GetMapping(path = "/luxury")
    public ResponseUtil getAllLuxuryCars() {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getAllLuxuryCars());
    }

    @GetMapping(path = "/premium")
    public ResponseUtil getAllPremiumCars() {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getAllPremiumCars());
    }

    @GetMapping(path = "/general")
    public ResponseUtil getAllGeneralCars() {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getAllGeneralCars());
    }

    @GetMapping(path = "/availableCount")
    public ResponseUtil getAvailableAndReservedCarCount() {
        return new ResponseUtil("OK", "Successfully Loaded. :", carService.getAvailableAndReservedCarCount());
    }

    @DeleteMapping(params = {"registrationNo"})
    public ResponseUtil deleteCar(@RequestParam String registrationNo) {
        carService.deleteCar(registrationNo);
        return new ResponseUtil("OK", "Successfully Deleted", null);
    }

    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDTO dto) {
        carService.updateCar(dto);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getRegistrationNo(), null);
    }
}
