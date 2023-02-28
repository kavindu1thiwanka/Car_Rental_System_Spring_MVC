package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverEmail;
    private String driverName;
    private String driverAddress;
    private String driverNICorLicenceNo;
    private int driverContact;
    private String img;
    private String available;
}
