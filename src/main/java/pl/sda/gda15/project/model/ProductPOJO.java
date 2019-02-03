package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.gda15.project.domain.entity.Product;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductPOJO {
    private UUID productId;
    private Double price;
    private String productName;
    private Long quantity;


}
