package pl.gucio.enzo.chronica.user.domain.model;


import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class PersonalInformation {
    private String name;
    private String lastName;
    private Integer age;
}
