package org.chronica.library.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.chronica.library.commons.dto.EntityDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO extends EntityDTO {
    private String name;
    private String lastName;
    private Integer age;
}
