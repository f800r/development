package de.microservice.rechner.controller;


import de.microservice.rechner.data.RechnerDataStore;
import de.microservice.rechner.data.RechnerDataStoreImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static de.microservice.rechner.data.RechnerDataStore.Repo.IPD;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RechnerResourceData {
    private final RechnerDataStore rechnerDataStore;

    public RechnerResourceData() {
        rechnerDataStore = new RechnerDataStoreImpl();
    }

    @RequestMapping(value = "/data", method = GET)
    public String showText(@RequestParam(value = "xpath", defaultValue = "/configuration/stage/user/text()") String xPathQuery) {
        try {
            return rechnerDataStore.ermittleKonfig(IPD, xPathQuery);
        } catch (Exception cause) {
            throw new RuntimeException(cause);
        }
    }
}
