package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
}
