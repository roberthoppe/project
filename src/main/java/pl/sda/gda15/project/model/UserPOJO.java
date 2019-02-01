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

public class UserPOJO {

    private UUID userID;

    private String name;
    private String surname;
    private String adres;
    private String city;
    private String country;
    private String email;
    private Integer tel;

}
