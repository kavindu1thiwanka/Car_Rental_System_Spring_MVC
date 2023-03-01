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
public class User {
    @Id
    private String userEmail;
    private String userName;
    private String userAddress;
    private String userNICorLicenceNo;
    private int userContact;

    @OneToOne(cascade = CascadeType.ALL)
    private AllUsers allUsers;
}
