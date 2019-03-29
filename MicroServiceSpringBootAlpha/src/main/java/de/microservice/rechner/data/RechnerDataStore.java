package de.microservice.rechner.data;

public interface RechnerDataStore {
    String ermittleKonfig(Repo repo, String xPathQuery);

    public enum Repo {
        IPD
    }
}
