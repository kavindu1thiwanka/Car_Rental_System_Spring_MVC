package lk.ijse.easyCar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bk_id;
    private String bk_cusEmail;
    private String bk_car;
    private String bk_date;
    private String bk_returnDate; //end date
    private double bk_total;
    private String bk_status;
}
