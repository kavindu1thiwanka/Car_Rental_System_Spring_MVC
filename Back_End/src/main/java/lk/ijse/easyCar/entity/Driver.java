package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String driverEmail;
    private String driverName;
    private String driverAddress;
    private String driverNICorLicenceNo;
    private int driverContact;
    private String img;
    private String available;

    @OneToOne(cascade = CascadeType.ALL)
    private AllUsers allUsers;
}
