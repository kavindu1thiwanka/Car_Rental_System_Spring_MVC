package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bkId;
    private String bkCusEmail;
    private String bkCar;
    private String bkDate;
    private String bkReturnDate;
    private double bkTotal;
    private String bkDriver;
    private String bkStatus;
}
