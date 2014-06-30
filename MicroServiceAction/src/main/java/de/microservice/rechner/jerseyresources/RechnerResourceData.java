package de.microservice.rechner.jerseyresources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import de.microservice.rechner.data.RechnerDataStore;
import de.microservice.rechner.data.RechnerDataStoreImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static de.microservice.rechner.data.RechnerDataStore.Repo.IPD;

@Path("/data")
@Produces(MediaType.TEXT_PLAIN)
public class RechnerResourceData {

    private final String defaultXpathQuery;
    private final RechnerDataStore rechnerDataStore;

    public RechnerResourceData(String defaultXpathQuery) {
        this.defaultXpathQuery = defaultXpathQuery;
        rechnerDataStore = new RechnerDataStoreImpl();
    }

    @GET
    @Timed
    public String showText(@QueryParam("xpath") Optional<String> xPathQuery) {
        try {
            return rechnerDataStore.ermittleKonfig(IPD, xPathQuery.or(defaultXpathQuery));
        } catch (Exception cause) {
            throw new WebApplicationException(cause, Response.Status.BAD_REQUEST);
        }
    }

}