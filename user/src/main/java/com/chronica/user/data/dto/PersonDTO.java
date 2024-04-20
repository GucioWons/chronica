package com.chronica.user.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.dto.EntityDTO;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO extends EntityDTO {
    private String name;
    private String lastName;
    private Integer age;
}
