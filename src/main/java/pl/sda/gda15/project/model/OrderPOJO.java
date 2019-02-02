package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderPOJO {

    private UUID orderId;
    private Date orderData;
    //private List<ProductPOJO>productList;
}
