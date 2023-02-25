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

    private String userName;
    private String userAddress;
    private String userNICNo;
    private int userContact;
    @Id
    private String email;
    private String role;
    private String img;
    private String pwd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "availability",referencedColumnName = "email")
    private Driver driver;
}
