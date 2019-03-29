package de.microservice.rechner.prometheus;

import com.jayway.restassured.RestAssured;
import de.microservice.rechner.application.RechnerApplication;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.config.SSLConfig.sslConfig;
import static org.springframework.util.ResourceUtils.getFile;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RechnerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RechnerPrometheusConfigurationTest {

    @Value("${local.server.port}")
    int port;
    @Value("${keystore.resourcepath}")
    private String keystoreResource;
    @Value("${keystore.password}")
    private String keystorePassword;

    @Before
    public void setUp() throws FileNotFoundException {

        final String keystoreFile = getFile(keystoreResource).getAbsolutePath();
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().with()
                .keystoreType("PKCS12").and()
                .allowAllHostnames().and()
                .keystore(keystoreFile, keystorePassword));

        RestAssured.port = port;
        RestAssured.baseURI = "https://localhost";
    }

    @Test()
    public void metricsUrlLiefertRechnerMetrics() {
        expect().statusCode(HttpStatus.SC_OK).when().get("/metrics");
        expect().statusCode(HttpStatus.SC_OK).when().get("/prometheus");
        expect().statusCode(HttpStatus.SC_OK).when().get("/prometheusMetricsServlet");
    }

    @Test
    public void springBootMetricsLiefertRechnerMetrics() throws IOException {
        assertTrue(get("/metrics").asString().contains("rechner.counter"));
    }

    @Test
    public void annotationEnabledPrometheusMetricsLiefertRechnerMetrics() throws IOException {
        assertTrue(get("/prometheus").asString().contains("rechner_counter"));
    }

    @Test
    public void manualConfiguredPrometheusMetricsLiefertRechnerMetrics() throws IOException {
        assertTrue(get("/prometheusMetricsServlet").asString().contains("rechner_counter"));
    }
}