package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String registrationNum;
    private String brand;
    private String carType;
    private int passengers;
    private String fuelType;
    private double dailyPrice;
    private double monthlyPrice;
    private int extraKM;
    private String color;
}
