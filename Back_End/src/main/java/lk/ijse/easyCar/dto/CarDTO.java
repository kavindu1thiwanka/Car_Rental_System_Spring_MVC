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
    private String imgFront;
    private String imgBack;
    private String imgSide;
    private String imgInside;
}
