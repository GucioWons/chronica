package com.chronica.notification.logic;

import com.chronica.notification.data.entity.NotificationAbstractEntity;

import java.util.Optional;

public interface BasicService<Entity extends NotificationAbstractEntity> {
    void save(Entity entity);}
