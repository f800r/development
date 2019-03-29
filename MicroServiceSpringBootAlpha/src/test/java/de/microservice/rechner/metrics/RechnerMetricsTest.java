package de.microservice.rechner.metrics;

import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.core.Ordered;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;


public class RechnerMetricsTest {

    private RechnerMetrics underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new RechnerMetrics();
    }

    @Test
    public void orderIsHighestPrecedencePlusTwenty() {
        Assert.assertEquals(underTest.getOrder(), Ordered.HIGHEST_PRECEDENCE + 20);
    }

    @Test
    public void metrikenWerdenGeliefert() {
        Collection<Metric<?>> actual = underTest.metrics();
        Assert.assertFalse(actual.isEmpty());
    }
}