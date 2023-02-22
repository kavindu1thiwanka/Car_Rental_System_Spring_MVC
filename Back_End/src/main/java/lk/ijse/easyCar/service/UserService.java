package lk.ijse.easyCar.service;

import lk.ijse.easyCar.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {
    void checkLogin(UserDTO userDTO);
    ArrayList<UserDTO> getAllCustomers();
    void deleteCustomer(String userID);
}
