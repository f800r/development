package de.microservice.rechner.prometheus;

import de.microservice.rechner.metrics.RechnerMetrics;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.spring.boot.SpringBootMetricsCollector;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class RechnerPrometheusConfiguration {

    @Bean
    public CollectorRegistry collectorRegistry() {
        return new CollectorRegistry();
    }

    @Bean
    public SpringBootMetricsCollector metricsCollector(final Collection<PublicMetrics> metrics, final CollectorRegistry registry) {
        return new SpringBootMetricsCollector(metrics).register(registry);
    }

    @Bean
    public RechnerMetrics rechnerPrometheusMetrics() {
        return new RechnerMetrics();
    }

    @Bean
    public ServletRegistrationBean exporterServlet(final CollectorRegistry registry) {
        return new ServletRegistrationBean(new MetricsServlet(registry), "/prometheusMetricsServlet");
    }
}

