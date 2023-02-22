package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarDTO> getAllCars();
    void addLuxuryCars();
    void addPremiumCars();
    void addGeneralCars();
}
