package lk.ijse.easyCar.controller;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.service.CarService;
import lk.ijse.easyCar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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

    @PostMapping(path = "/saveImg", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveImage(CarDTO carDTO, @RequestPart("imgFrontFile") MultipartFile file1, @RequestPart("imgSideFile") MultipartFile file2, @RequestPart("imgBackFile") MultipartFile file3, @RequestPart("imgInsideFile") MultipartFile file4) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
            file2.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
            file3.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));
            file4.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + file1.getOriginalFilename()));

            carDTO.setImgFront("uploads/" + file1.getOriginalFilename());
            carDTO.setImgSide("uploads/" + file2.getOriginalFilename());
            carDTO.setImgBack("uploads/" + file3.getOriginalFilename());
            carDTO.setImgInside("uploads/" + file4.getOriginalFilename());
            carService.saveCar(carDTO);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("Ok", "Successfully Saved", null);
        }
        return new ResponseUtil("Ok", "Successfully Saved", null);
    }
}
