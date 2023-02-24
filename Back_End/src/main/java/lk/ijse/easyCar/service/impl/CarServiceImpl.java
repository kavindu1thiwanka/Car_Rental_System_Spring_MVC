package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.entity.Car;
import lk.ijse.easyCar.repo.CarRepo;
import lk.ijse.easyCar.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
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

    @Override
    public void saveCar(CarDTO dto) {
        if(carRepo.existsById(dto.getRegistrationNo())){
            throw new RuntimeException("User already exist!");
        }

        try {

            File uploadsDir = new File("\\home\\kavindu\\IJSE\\Work\\Car_Rental\\Back_End\\src\\main\\java\\lk\\ijse\\easyCar\\storage" + "/uploads");
            uploadsDir.mkdir();
            dto.getImg().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getImg().getOriginalFilename()));

            Car car = new Car();
            String fileName = StringUtils.cleanPath(dto.getImg().getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("Can't Process Image");
                throw new RuntimeException("Can't Process Image!");
            }
            car.setRegistrationNo(dto.getRegistrationNo());
            car.setCarBrand(dto.getCarBrand());
            car.setCarType(dto.getCarType());
            car.setNumberOfPassengers(dto.getNumberOfPassengers());
            car.setTransmissionType(dto.getTransmissionType());
            car.setFuelType(dto.getFuelType());
            car.setFuelType(dto.getFuelType());
            car.setDailyPrice(dto.getDailyPrice());
            car.setMonthlyPrice(dto.getMonthlyPrice());
            car.setPriceForExtraKM(dto.getPriceForExtraKM());
            car.setColor(dto.getColor());
            car.setAvailable("Available");
            car.setStatus("Good");
//            car.setImg("uploads/" + dto.getImg().getOriginalFilename());

            carRepo.save(car);

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Something went wrong! : "+e);
        }
    }
}
