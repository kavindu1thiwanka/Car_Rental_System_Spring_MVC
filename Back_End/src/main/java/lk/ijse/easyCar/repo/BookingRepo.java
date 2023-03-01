package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,String> {
    List<Booking> findByBkDriver(String bkDriver);

}
