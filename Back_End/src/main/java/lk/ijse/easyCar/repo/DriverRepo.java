package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Driver;
import lk.ijse.easyCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    List<User> findByAvailable(String status);
}
