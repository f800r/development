package de.microservice.rechner.data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RechnerDataStoreImplTest {

    private RechnerDataStore rechnerDataStore;

    @BeforeMethod
    public void setUp() {
        rechnerDataStore = new RechnerDataStoreImpl();
    }

    @DataProvider
    public Object[][] ipdXpathPruefungen() {
        return new Object[][]{
                {"/configuration/stage/server[1]/text()", "solv048.f800r.local", ""},
                {"/configuration/stage/server[2]/text()", "solv049.f800r.local", ""},
                {"/configuration/settings/baseport/text()", "130", ""}
        };
    }

    @Test(dataProvider = "ipdXpathPruefungen")
    public void ipdProdStagesWerdenErmittelt(String xPathQuery, String ergebnis, String multipleResults) {
        String rolloutConfig = rechnerDataStore.ermittleKonfig(RechnerDataStore.Repo.IPD, xPathQuery);
        System.out.println(rolloutConfig);
        assertTrue(rolloutConfig.contains(ergebnis));
        assertTrue(rolloutConfig.contains(multipleResults));
    }
}