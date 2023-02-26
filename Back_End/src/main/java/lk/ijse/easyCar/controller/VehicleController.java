package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
        System.out.println("===============================================================");
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

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadFileWithSpringWay(@RequestPart("registrationNo") String registrationNo, @RequestPart("carBrand") String carBrand, @RequestPart("carType") String carType, @RequestPart("numberOfPassengers") int numberOfPassengers, @RequestPart("transmissionType") String transmissionType, @RequestPart("fuelType") String fuelType, @RequestPart("dailyPrice") double dailyPrice, @RequestPart("monthlyPrice") double monthlyPrice, @RequestPart("priceForExtraKM") double priceForExtraKM, @RequestPart("color") String color, @RequestPart("available") String available, @RequestPart("status") String status, @RequestPart("imgFront") MultipartFile imgFront, @RequestPart("imgBack") MultipartFile imgBack, @RequestPart("imgSide") MultipartFile imgSide, @RequestPart("imgInside") MultipartFile imgInside) {
    System.out.println("POST EKATA ENAWA");
    try {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
        File uploadsDir = new File(projectPath + "/uploads");
        System.out.println(projectPath);
        uploadsDir.mkdir();
        imgFront.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + imgFront.getOriginalFilename()));
        imgBack.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + imgBack.getOriginalFilename()));
        imgSide.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + imgSide.getOriginalFilename()));
        imgInside.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + imgInside.getOriginalFilename()));

        //save the path of the uploaded image in the temporary database
//        allImages.add("uploads/" + imgFront.getOriginalFilename());
//        allImages.add("uploads/" + imgBack.getOriginalFilename());
//        allImages.add("uploads/" + imgSide.getOriginalFilename());
//        allImages.add("uploads/" + imgInside.getOriginalFilename());

        CarDTO carDTO = new CarDTO(registrationNo, carBrand, carType, numberOfPassengers, transmissionType, fuelType, dailyPrice, monthlyPrice, priceForExtraKM, color, available, status, "uploads/" + imgFront.getOriginalFilename(), "uploads/" + imgBack.getOriginalFilename(), "uploads/" + imgSide.getOriginalFilename(), "uploads/" + imgInside.getOriginalFilename());

        carService.saveCar(carDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    } catch (URISyntaxException e) {
        e.printStackTrace();
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (IOException e) {
        e.printStackTrace();
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @DeleteMapping(params = {"registrationNo"})
    public ResponseUtil deleteCar(@RequestParam String registrationNo) {
        carService.deleteCar(registrationNo);
        return new ResponseUtil("OK", "Successfully Deleted", null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CarDTO dto) {
        carService.updateCar(dto);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getRegistrationNo(), null);
    }
}
