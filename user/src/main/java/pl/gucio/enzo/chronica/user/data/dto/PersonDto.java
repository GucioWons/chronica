package pl.gucio.enzo.chronica.user.data.dto;


import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class PersonDto {
    private String name;
    private String lastName;
    private Integer age;
}
