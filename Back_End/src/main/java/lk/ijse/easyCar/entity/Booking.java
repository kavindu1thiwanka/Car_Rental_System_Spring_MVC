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
public class Booking {

    @Id
    private String bkId;
    private String bkCusEmail;
    private String bkCar;
    private String bkDate;
    private String bkReturnDate;
    private double bkTotal;
    private String bkDriver;
    private String bkStatus;
}
