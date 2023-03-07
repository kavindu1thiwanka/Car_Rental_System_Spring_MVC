package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.CarDTO;
import lk.ijse.easyCar.entity.Car;
import lk.ijse.easyCar.repo.CarRepo;
import lk.ijse.easyCar.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(carRepo.findAll(), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public void saveCar(CarDTO dto) {
        if (carRepo.existsById(dto.getRegistrationNo())) {
            throw new RuntimeException("User already exist!");
        }

        Car map = mapper.map(dto, Car.class);
        carRepo.save(map);

    }

    @Override
    public void deleteCar(String registrationNo) {
        if (!carRepo.existsById(registrationNo)) {
            throw new RuntimeException("Car Registration Number Does Not Exist..!");
        }
        carRepo.deleteById(registrationNo);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getRegistrationNo())) {
            throw new RuntimeException("Car Registration Number Does Not Exist..!");
        }
        carRepo.save(mapper.map(dto, Car.class));
    }

    @Override
    public ArrayList<Integer> getAvailableAndReservedCarCount() {
        ArrayList<Integer> arrayList = new ArrayList();
        int availableCount;
        int reservedCount;
        List<Car> available = carRepo.findByAvailable("Available");
        availableCount = available.size();
        List<Car> reserved = carRepo.findByAvailable("Reserved");
        reservedCount = reserved.size();

        arrayList.add(availableCount);
        arrayList.add(reservedCount);
        return arrayList;
    }

    @Override
    public ArrayList<CarDTO> getAllLuxuryCars() {
        List<Car> carList = carRepo.findByCarType("Luxury");
//        for (Car c : carList) {
//            for (Car x : carList) {
//                if (c.getCarBrand().equals(x.getCarBrand())){
//                    carList.remove(c);
//                }else {
//                    continue;
//                }
//            }
//        }
        return mapper.map(carList, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    public ArrayList<CarDTO> getAllPremiumCars() {
        List<Car> carList = carRepo.findByCarType("Premium");
//        for (Car c : carList) {
//            for (Car x : carList) {
//                if (c.getCarBrand().equals(x.getCarBrand())){
//                    carList.remove(c);
//                }else {
//                    continue;
//                }
//            }
//        }
        return mapper.map(carList, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> getVehicleDetailsByID(String id) {
        return mapper.map(carRepo.findByRegistrationNo(id), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> getAllGeneralCars() {
        List<Car> carList = carRepo.findByCarType("General");
//        for (Car c : carList) {
//            for (Car x : carList) {
//                if (c.getCarBrand().equals(x.getCarBrand())){
//                    carList.remove(c);
//                }else {
//                    continue;
//                }
//            }
//        }
        return mapper.map(carList, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }
}
