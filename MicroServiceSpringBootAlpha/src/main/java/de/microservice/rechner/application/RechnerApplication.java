package de.microservice.rechner.application;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.springframework.util.ResourceUtils.getFile;

@Configuration
@EnableAutoConfiguration
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@ComponentScan(basePackages = {
        "de.microservice.rechner.controller",
        "de.microservice.rechner.prometheus"
}
)
public class RechnerApplication {

    @Value("${keystore.resourcepath}")
    private String keystoreResource;

    @Value("${keystore.password}")
    private String keystorePassword;


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RechnerApplication.class, args);

        System.out.println(ctx.getApplicationName());

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("BeanDefinitionNames=" + beanName);
        }
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() throws FileNotFoundException {

        // http://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html
        // keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
        // keytool -list -v -keystore keystore.p12 -storetype pkcs12
        // curl -k https://127.0.0.1

        final String keystoreFile = getFile(keystoreResource).getAbsolutePath();
        final String keystorePass = keystorePassword;
        final String keystoreType = "PKCS12";
        final String keystoreProvider = "SunJSSE";
        final String keystoreAlias = "tomcat";

        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector con) {
                con.setScheme("https");
                con.setSecure(true);
                Http11NioProtocol proto = (Http11NioProtocol) con.getProtocolHandler();
                proto.setSSLEnabled(true);
                proto.setKeystoreFile(keystoreFile);
                proto.setKeystorePass(keystorePass);
                proto.setKeystoreType(keystoreType);
                proto.setProperty("keystoreProvider", keystoreProvider);
                proto.setKeyAlias(keystoreAlias);
            }
        });

        return factory;
    }

}
