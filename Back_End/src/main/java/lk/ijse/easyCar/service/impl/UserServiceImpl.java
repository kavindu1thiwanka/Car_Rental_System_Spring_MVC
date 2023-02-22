package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.repo.UserRepo;
import lk.ijse.easyCar.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void checkLogin(UserDTO userDTO) {

    }

    @Override
    public ArrayList<UserDTO> getAllCustomers() {
        return mapper.map(userRepo.findAll(),new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

    @Override
    public void deleteCustomer(String userID) {
        if (!userRepo.existsById(userID)){
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        userRepo.deleteById(userID);
    }
}
