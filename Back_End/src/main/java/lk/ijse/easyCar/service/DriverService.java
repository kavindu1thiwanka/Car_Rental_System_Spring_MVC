package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void addDriver();

    ArrayList<DriverDTO> getAllDrivers();
}
