package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.AllUserDTO;
import lk.ijse.easyCar.dto.DriverDTO;
import lk.ijse.easyCar.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDTO> getAllUsers();

    void registerUser(UserDTO dto);

    ArrayList<DriverDTO> getAllDrivers();

    ArrayList<DriverDTO> getAllAvailableDrivers();

    void deleteUser(String email);

    void saveUser(UserDTO userDTO);

    int getAllUsersCount();

    Object getAllDriversCount();

    ArrayList<AllUserDTO> getAll();

    void deleteDriver(String email);

    void saveToAllUser(AllUserDTO allUserDTO);

    ArrayList<UserDTO> getUserDetails(String userEmail);

    ArrayList<DriverDTO> getDriverDetails(String driverEmail);

    void updateUser(UserDTO dto);

    void updateUserPwd(AllUserDTO dto);

    void saveDriver(DriverDTO dto);
}
