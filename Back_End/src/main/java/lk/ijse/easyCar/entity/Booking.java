package lk.ijse.easyCar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Booking {

    @Id
    private String bk_id;
    private String bk_cusEmail;
    private String bk_car;
    private String bk_date;
    private String bk_returnDate; //end date
    private double bk_total;
    private String bk_status;
}
