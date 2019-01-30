package pl.sda.gda15.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotNull

public class UserPOJO {

    private UUID userId;

    private String name;
    private String surname;
    private String adres;
    private String city;
    private String country;
    private String email;
    private Integer tel;

}
