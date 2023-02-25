package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    List<Car> findByAvailable(String status);
}
