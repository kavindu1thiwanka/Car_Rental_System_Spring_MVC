package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarImageDTO {
    private String registrationNo;
    private String imgFront;
    private String imgBack;
    private String imgSide;
    private String imgInside;
}
