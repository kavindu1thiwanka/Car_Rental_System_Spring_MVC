package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.dto.UserDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarDTO> getAllCars();
    void addLuxuryCars();
    void addPremiumCars();
    void addGeneralCars();

    void saveCar(CarDTO dto);

    void deleteCar(String registrationNo);

    void updateCar(CarDTO dto);

    ArrayList<Integer> getAvailableAndReservedCarCount();
}
