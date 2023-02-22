package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.repo.UserRepo;
import lk.ijse.easyCar.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void checkLogin(UserDTO userDTO) {

    }
}
