package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class VehicleController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded. :" ,carService.getAllCars());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto){
        carService.saveCar(dto);
        return new ResponseUtil("OK","Successfully Registered.!",null);
    }

    @DeleteMapping(params = {"registrationNo"})
    public ResponseUtil deleteCustomer(@RequestParam String registrationNo){
        carService.deleteCar(registrationNo);
        return new ResponseUtil("OK","Successfully Deleted" ,null);
    }
}
