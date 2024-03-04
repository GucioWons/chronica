package pl.gucio.enzo.chronica.user.data.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonDto {
    private String name;
    private String lastName;
    private Integer age;
}
