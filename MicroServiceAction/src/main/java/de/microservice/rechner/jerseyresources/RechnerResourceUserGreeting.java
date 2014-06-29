package de.microservice.rechner.jerseyresources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import de.microservice.rechner.representation.RechnerRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class RechnerResourceUserGreeting {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public RechnerResourceUserGreeting(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public RechnerRepresentation sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new RechnerRepresentation(counter.incrementAndGet(), value);
    }

}