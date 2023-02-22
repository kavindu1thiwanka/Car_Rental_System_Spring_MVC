package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.DriverDTO;
import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.repo.DriverRepo;
import lk.ijse.easyCar.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public void addDriver() {

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return mapper.map(driverRepo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
