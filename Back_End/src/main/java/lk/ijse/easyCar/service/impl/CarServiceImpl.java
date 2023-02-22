package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.repo.CarRepo;
import lk.ijse.easyCar.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(carRepo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public void addLuxuryCars() {

    }

    @Override
    public void addPremiumCars() {

    }

    @Override
    public void addGeneralCars() {

    }
}
