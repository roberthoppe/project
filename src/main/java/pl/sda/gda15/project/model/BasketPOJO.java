package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BasketPOJO {
    private UUID orderId;
    private String OrderName;
   // private Date orderDate;
}
