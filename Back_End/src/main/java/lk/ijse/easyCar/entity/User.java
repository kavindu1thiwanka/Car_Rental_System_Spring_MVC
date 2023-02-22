package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(UserLogin_PK.class)
public class User {
    @Id
    private String userID;
    private String userName;
    private String userAddress;
    private String userNICNo;
    private int userContact;
    @Id
    private String email;
    private String role;
}
