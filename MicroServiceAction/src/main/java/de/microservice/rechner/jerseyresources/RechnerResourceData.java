package de.microservice.rechner.jerseyresources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import de.microservice.rechner.data.RechnerDataStore;
import de.microservice.rechner.data.RechnerDataStoreImpl;
import de.microservice.rechner.representation.RechnerRepresentation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static de.microservice.rechner.data.RechnerDataStore.Repo.IPD;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class RechnerResourceData {

    private final String defaultXpathQuery;
    private final RechnerDataStore rechnerDataStore;

    public RechnerResourceData(String defaultXpathQuery) {
        this.defaultXpathQuery = defaultXpathQuery;
        rechnerDataStore = new RechnerDataStoreImpl();
    }

    @GET
    @Timed
    public RechnerRepresentation showText(@QueryParam("xpath") Optional<String> xPathQuery) {
        try {
            String s = rechnerDataStore.ermittleKonfig(IPD, xPathQuery.or(defaultXpathQuery));
            return new RechnerRepresentation(1l, s);
        } catch (Exception cause) {
            throw new WebApplicationException(cause, Response.Status.BAD_REQUEST);
        }
    }

}