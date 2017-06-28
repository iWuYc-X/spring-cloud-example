package com.iwuyc.microservice.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthService implements HealthIndicator
{

    @Override
    public Health health()
    {
        return Health.down().withDetail("Error Code", 1999).withException(new NullPointerException("It's nil.")).build();
    }

}
