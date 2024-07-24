package com.chronica.gateway;

import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;


@EnableRedisWebSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
}