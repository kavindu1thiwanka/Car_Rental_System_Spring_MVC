package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {
    List<Driver> findByAvailable(String status);

    List<Driver> findByDriverEmail(String driverEmail);
}
