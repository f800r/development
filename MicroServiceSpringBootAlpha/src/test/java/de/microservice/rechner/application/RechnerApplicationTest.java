package de.microservice.rechner.application;

import com.jayway.restassured.RestAssured;
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
import static com.jayway.restassured.parsing.Parser.TEXT;
import static org.springframework.util.ResourceUtils.getFile;
import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RechnerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RechnerApplicationTest {

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

    @Test
    public void welcomeTextIsCreated() {
        expect().statusCode(HttpStatus.SC_OK).when().get("/");
    }

    @Test
    public void welcomeTextWirdAlsTextPlainAusgegeben() {
        final String mimeType = "text/plain";
        RestAssured.registerParser(mimeType, TEXT);
        try {
            expect().contentType(mimeType).when().get("/");
        } finally {
            RestAssured.unregisterParser(mimeType);
        }
    }

    @Test
    public void welcomeText() throws IOException {
        assertEquals(get("/").asString(), "Greetings from Spring Boot!");
    }

    @Test
    public void dataStoreXpathCheck() throws IOException {
        String queryResult = get("/data?xpath=/configuration/stage/server/text()").asString();
        assertEquals(queryResult, "solv048.f800r.local solv049.f800r.local");
    }

}