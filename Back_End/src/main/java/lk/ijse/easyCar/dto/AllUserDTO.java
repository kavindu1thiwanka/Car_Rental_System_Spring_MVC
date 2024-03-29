package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AllUserDTO {
    private String userId;
    private String userEmail;
    private String userPwd;
    private String role;
}
