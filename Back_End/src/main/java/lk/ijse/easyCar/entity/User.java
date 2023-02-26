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
//@IdClass(UserLogin_PK.class)
public class User {
    @Id
    private String userEmail;
    private String userName;
    private String userAddress;
    private String userNICorLicenceNo;
    private int userContact;
    private String img;
    private String userPwd;

    @OneToOne(cascade = CascadeType.ALL)
    private AllUsers allUsers;
}
