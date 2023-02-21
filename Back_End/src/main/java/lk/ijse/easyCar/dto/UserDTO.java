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
    private String userID;
    private String userName;
    private String userAddress;
    private String userNICNo;
    private int userContact;
    private String email;
}
