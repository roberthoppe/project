package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductPOJO {
    private UUID productId;

    private String productName;
    private Integer quantity;
}
