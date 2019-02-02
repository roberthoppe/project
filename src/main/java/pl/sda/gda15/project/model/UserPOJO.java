package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserPOJO {

    private UUID userId;

    private String name;
    private String surname;
    private String adres;
    private String city;
    private String country;
    private String email;
    private Long tel;
    private List<OrderPOJO> orderList;

}
