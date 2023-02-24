package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String registrationNo;
    private String carBrand;
    private String carType;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double dailyPrice;
    private double monthlyPrice;
    private double priceForExtraKM;
    private String color;
    private String available;
    private String status;
}
