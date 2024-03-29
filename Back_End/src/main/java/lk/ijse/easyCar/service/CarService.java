package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarDTO> getAllCars();

    void saveCar(CarDTO dto);

    void deleteCar(String registrationNo);

    void updateCar(CarDTO dto);

    ArrayList<Integer> getAvailableAndReservedCarCount();

    ArrayList<CarDTO> getAllLuxuryCars();

    ArrayList<CarDTO> getAllGeneralCars();

    ArrayList<CarDTO> getAllPremiumCars();

    ArrayList<CarDTO> getVehicleDetailsByID(String id);
}
