package de.microservice.rechner.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class RechnerHealthCheck extends HealthCheck {
    private final String template;

    public RechnerHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "MARKER");
        if (!saying.contains("MARKER")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}