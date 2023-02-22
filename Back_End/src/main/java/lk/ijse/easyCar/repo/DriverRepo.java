package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
