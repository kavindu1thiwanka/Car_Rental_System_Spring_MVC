package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
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
