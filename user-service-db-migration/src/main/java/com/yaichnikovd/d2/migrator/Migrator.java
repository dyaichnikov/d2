package com.yaichnikovd.d2.migrator;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Migrator {

    private final Flyway flyway;

    public void migrate() {
        flyway.migrate();
    }

    public void clean() {
        flyway.clean();
    }
}
