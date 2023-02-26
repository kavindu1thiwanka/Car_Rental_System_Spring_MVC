package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
