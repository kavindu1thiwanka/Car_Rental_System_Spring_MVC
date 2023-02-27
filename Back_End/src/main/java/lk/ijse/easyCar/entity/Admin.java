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
public class Admin {
    @Id
    private String adminEmail;
    private String adminName;
    private String adminNICno;

    @OneToOne(cascade = CascadeType.ALL)
    private AllUsers allUsers;
}
