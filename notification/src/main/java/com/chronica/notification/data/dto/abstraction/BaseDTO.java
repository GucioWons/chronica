package com.chronica.notification.data.dto.abstraction;


import com.chronica.notification.data.dto.AlertDTO;
import com.chronica.notification.data.dto.InvitationDTO;
import com.chronica.notification.data.dto.MessageDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;



@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlertDTO.class, name = "alert"),
        @JsonSubTypes.Type(value = InvitationDTO.class, name = "invitation"),
        @JsonSubTypes.Type(value = MessageDTO.class, name = "message")
})
@NoArgsConstructor
public abstract class BaseDTO {

}
