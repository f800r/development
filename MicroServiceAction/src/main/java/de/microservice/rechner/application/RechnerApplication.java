package de.microservice.rechner.application;

import de.microservice.rechner.config.RechnerConfiguration;
import de.microservice.rechner.healthcheck.RechnerHealthCheck;
import de.microservice.rechner.jerseyresources.RechnerResourceData;
import de.microservice.rechner.jerseyresources.RechnerResourceDateTime;
import de.microservice.rechner.jerseyresources.RechnerResourceUserGreeting;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RechnerApplication extends Application<RechnerConfiguration> {
    public static void main(String[] args) throws Exception {
        new RechnerApplication().run(args);
    }

    @Override
    public String getName() {
        return "RechnerApplication";
    }

    @Override
    public void initialize(Bootstrap<RechnerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(RechnerConfiguration configuration,
                    Environment environment) {
        final RechnerResourceUserGreeting resource = new RechnerResourceUserGreeting(
                configuration.getTemplate(),
                configuration.getDefaultName());
        environment.jersey().register(resource);

        final RechnerResourceDateTime resourceDateTime = new RechnerResourceDateTime(
                configuration.getDefaultJahr());
        environment.jersey().register(resourceDateTime);

        final RechnerResourceData rechnerResourceData = new RechnerResourceData(configuration.getDefaultXpathQuery());
        environment.jersey().register(rechnerResourceData);


        final RechnerHealthCheck healtCheck = new RechnerHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("einAnfang", healtCheck);

    }

}
