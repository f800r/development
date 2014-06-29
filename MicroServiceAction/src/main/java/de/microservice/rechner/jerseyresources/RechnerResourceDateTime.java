package de.microservice.rechner.jerseyresources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import de.microservice.rechner.representation.RechnerRepresentation;
import org.joda.time.DateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/datetime")
@Produces(MediaType.APPLICATION_JSON)
public class RechnerResourceDateTime {
    private final Integer dafaultJahr;
    private final AtomicLong counter;

    public RechnerResourceDateTime(Integer dafaultJahr) {
        this.dafaultJahr = dafaultJahr;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public RechnerRepresentation sayDateTime(@QueryParam("year") Optional<Integer> year) {
        DateTime datetime = new DateTime(year.or(dafaultJahr).intValue());
        final String value = String.format("%d", datetime.getMillis());
        return new RechnerRepresentation(counter.incrementAndGet(), value);
    }

}