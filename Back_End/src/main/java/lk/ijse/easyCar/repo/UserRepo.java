package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {
    List<User> findByUserEmail(String userEmail);
}
