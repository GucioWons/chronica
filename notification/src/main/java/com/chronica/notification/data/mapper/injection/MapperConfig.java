package com.chronica.notification.data.mapper.injection;

import com.chronica.notification.data.dto.abstraction.BaseDTO;
import com.chronica.notification.data.entity.Notification;
import com.chronica.notification.data.mapper.MapperMajorNotification;
import com.chronica.notification.data.mapper.implementation.MapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public MapperMajorNotification<BaseDTO, Notification> mapperConfiguration(){
        return new MapperMajorNotification<>(new MapperImpl<>());
    }



}
