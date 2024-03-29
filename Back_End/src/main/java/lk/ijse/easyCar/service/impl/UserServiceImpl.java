package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.AllUserDTO;
import lk.ijse.easyCar.dto.DriverDTO;
import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.entity.AllUsers;
import lk.ijse.easyCar.entity.Car;
import lk.ijse.easyCar.entity.Driver;
import lk.ijse.easyCar.entity.User;
import lk.ijse.easyCar.repo.AllUsersRepo;
import lk.ijse.easyCar.repo.DriverRepo;
import lk.ijse.easyCar.repo.UserRepo;
import lk.ijse.easyCar.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private AllUsersRepo allUsersRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        return mapper.map(userRepo.findAll(), new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public void registerUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserEmail())) {
            throw new RuntimeException("User Already Exist From This Email.Use Another Email..!");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<DriverDTO> getAllAvailableDrivers() {
        return mapper.map(driverRepo.findByAvailable("Available"), new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void deleteUser(String email) {
        if (!userRepo.existsById(email)) {
            throw new RuntimeException("User Does Not Exist..!");
        }
        allUsersRepo.deleteById(email);
        userRepo.deleteById(email);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserEmail())) {
            throw new RuntimeException("User already exists");
        }

        User map = mapper.map(userDTO, User.class);
        userRepo.save(map);
    }

    @Override
    public int getAllUsersCount() {
        int count;
        count = getAllUsers().size();
        return count;
    }

    @Override
    public Object getAllDriversCount() {
        int count;
        count = getAllDrivers().size();
        return count;
    }

    @Override
    public ArrayList<AllUserDTO> getAll() {
        return mapper.map(allUsersRepo.findAll(), new TypeToken<ArrayList<AllUserDTO>>() {
        }.getType());
    }

    @Override
    public void deleteDriver(String email) {
        if (!driverRepo.existsById(email)) {
            throw new RuntimeException("Driver Does Not Exist..!");
        }
        allUsersRepo.deleteById(email);
        driverRepo.deleteById(email);
    }

    @Override
    public void saveToAllUser(@RequestBody AllUserDTO allUserDTO) {
        if (allUsersRepo.existsById(allUserDTO.getUserEmail())) {
            throw new RuntimeException("User already exists");
        }

        AllUsers map = mapper.map(allUserDTO, AllUsers.class);
        allUsersRepo.save(map);
    }

    @Override
    public ArrayList<UserDTO> getUserDetails(String userEmail) {
        return mapper.map(userRepo.findByUserEmail(userEmail), new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<DriverDTO> getDriverDetails(String driverEmail) {
        return mapper.map(driverRepo.findByDriverEmail(driverEmail), new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUserEmail())){
            throw new RuntimeException("User Not Exist..!");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public void updateUserPwd(AllUserDTO dto) {
        if (!allUsersRepo.existsById(dto.getUserEmail())){
            throw new RuntimeException("User Not Exist..!");
        }
        allUsersRepo.save(mapper.map(dto, AllUsers.class));
    }

    @Override
    public void saveDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverEmail())) {
            throw new RuntimeException("Driver email already exists");
        }

        Driver map = mapper.map(dto, Driver.class);
        driverRepo.save(map);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDriverEmail())){
            throw new RuntimeException("User Not Exist..!");
        }
        driverRepo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public ArrayList<Integer> getAvailableAndReservedDriverCount() {
        ArrayList<Integer> arrayList = new ArrayList();
        int availableCount;
        int reservedCount;
        List<Driver> available = driverRepo.findByAvailable("Available");
        availableCount = available.size();
        List<Driver> reserved = driverRepo.findByAvailable("Unavailable");
        reservedCount = reserved.size();

        arrayList.add(availableCount);
        arrayList.add(reservedCount);
        return arrayList;
    }
}
