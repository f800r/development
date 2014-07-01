package de.microservice.rechner.livecycle;

import io.dropwizard.lifecycle.Managed;

public class DatabaseClientManager implements Managed {
    private final DatabaseClient client;

    public DatabaseClientManager(DatabaseClient client) {
        this.client = client;
    }

    @Override
    public void start() throws Exception {
        client.start();
    }

    @Override
    public void stop() throws Exception {
        client.stop();
    }
}

