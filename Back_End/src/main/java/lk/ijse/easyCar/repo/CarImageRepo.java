package lk.ijse.easyCar.repo;

import lk.ijse.easyCar.entity.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepo extends JpaRepository<CarImages, String> {
}
