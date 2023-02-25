package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.entity.User;
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
    public ArrayList<UserDTO> getAllUsers() {
        return mapper.map(userRepo.findAllUsers(),new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

    @Override
    public void registerUser(UserDTO dto) {
        if (userRepo.existsById(dto.getEmail())){   //// existsByEmail
            throw new RuntimeException("User Already Exist From This Email.Use Another Email..!");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public ArrayList<UserDTO> getAllDrivers() {
        return mapper.map(userRepo.findAllDrivers(),new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

    @Override
    public void deleteUser(String email) {
        if (!userRepo.existsById(email)){
            throw new RuntimeException("User Does Not Exist..!");
        }
        userRepo.deleteById(email);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User map = mapper.map(userDTO, User.class);
        userRepo.save(map);
    }

    @Override
    public int getAllUsersCount() {
        int count;
        count=getAllUsers().size();
        return count;
    }

    @Override
    public Object getAllDriversCount() {
        int count;
        count=getAllDrivers().size();
        return count;
    }
}
