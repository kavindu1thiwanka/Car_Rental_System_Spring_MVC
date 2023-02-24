package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.dto.UserDTO;
import lk.ijse.easyCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {

    @Query(value = "select * from User where role='User' ",nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "select * from User where role='Driver' ",nativeQuery = true)
    List<User> findAllDrivers();
}
