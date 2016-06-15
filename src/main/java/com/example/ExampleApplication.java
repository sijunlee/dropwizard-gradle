package com.example;

import com.example.health.ExampleApplicationHealth;
import com.example.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-example";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(new Java8Bundle());
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws ClassNotFoundException {

        //Register resources
        environment.jersey().register(
                new HelloWorldResource(
                        configuration.getTemplate(),
                        configuration.getDefaultName()
                )
        );

        //Register health checks
        environment.healthChecks().register(getName(), new ExampleApplicationHealth());
    }
}
