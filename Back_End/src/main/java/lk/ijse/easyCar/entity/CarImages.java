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
public class CarImages {
    @Id
    private String registrationNo;
    private String imgFront;
    private String imgBack;
    private String imgSide;
    private String imgInside;
}
