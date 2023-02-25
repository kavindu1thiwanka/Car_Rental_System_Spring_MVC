package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    ArrayList<UserDTO> getAllUsers();

    void registerUser(UserDTO dto);

    ArrayList<UserDTO> getAllDrivers();

    void deleteUser(String email);

    void saveUser(UserDTO userDTO);

    int getAllUsersCount();

    Object getAllDriversCount();

    ArrayList<UserDTO> getAll();
}
