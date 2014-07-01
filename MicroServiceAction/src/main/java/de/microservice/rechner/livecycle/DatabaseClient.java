package de.microservice.rechner.livecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseClient {

    final static Logger logger = LoggerFactory.getLogger(DatabaseClient.class);

    public void start() {
        logger.info("DatabaseClient livecyle start");
    }

    public void stop() {
        logger.info("DatabaseClient livecyle stop");
    }
}
