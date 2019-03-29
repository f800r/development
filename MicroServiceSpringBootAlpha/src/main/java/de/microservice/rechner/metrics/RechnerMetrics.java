package de.microservice.rechner.metrics;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.core.Ordered;

import java.util.Collection;
import java.util.LinkedHashSet;


public class RechnerMetrics implements PublicMetrics, Ordered {

    private static long counter = 0;

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 20;
    }

    @Override
    public Collection<Metric<?>> metrics() {
        Collection<Metric<?>> result = new LinkedHashSet<>();
        addRechnerMetrics(result);

        incrementCounter();
        return result;
    }

    private void addRechnerMetrics(Collection<Metric<?>> result) {
        result.add(new Metric<>("rechner.counter", counter));
    }

    private void incrementCounter() {
        counter++;
    }
}
