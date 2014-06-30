package de.microservice.rechner.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Note
 * The mapping from YAML to your application’s Configuration instance is done by Jackson.
 * This means your Configuration class can use all of Jackson’s object-mapping annotations.
 * The validation of @NotEmpty is handled by Hibernate Validator, which has a wide range of built-in constraints for you to use.
 */
public class RechnerConfiguration extends Configuration {
    @NotEmpty
    private String template;
    @NotEmpty
    private String defaultName = "Stranger";
    @NotEmpty
    private String defaultXpathQuery = "/configuration/stage/user/text()";
    private Integer defaultJahr = 2017;

    @JsonProperty
    public String getDefaultXpathQuery() {
        return defaultXpathQuery;
    }

    @JsonProperty
    public void setDefaultXpathQuery(String defaultXpathQuery) {
        this.defaultXpathQuery = defaultXpathQuery;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public Integer getDefaultJahr() {
        return defaultJahr;
    }

    @JsonProperty
    public void setDefaultJahr(String jahresZahl) {
        this.defaultJahr = Integer.valueOf(jahresZahl);
    }
}