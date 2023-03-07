package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {
    List<User> findByUserEmail(String userEmail);

//    @Query(value = "select * from User where id='C001'",nativeQuery = true)
//    User saveUserImg();
}
