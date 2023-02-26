package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userEmail;
    private String userName;
    private String userAddress;
    private String userNICorLicenceNo;
    private int userContact;
    private String img;
    private String userPwd;
}
