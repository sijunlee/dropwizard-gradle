package com.example.health;

import com.codahale.metrics.health.HealthCheck;

public class ExampleApplicationHealth extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
