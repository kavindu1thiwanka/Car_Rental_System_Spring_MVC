package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
    private String available;

    @OneToOne(cascade = CascadeType.ALL)
    private AllUsers allUsers;
}
