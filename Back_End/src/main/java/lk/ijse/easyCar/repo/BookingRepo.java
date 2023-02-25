package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {

}
