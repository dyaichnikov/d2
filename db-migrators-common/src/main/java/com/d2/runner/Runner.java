package com.d2.runner;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final Flyway flyway;

    @Override
    public void run(final String... args) {
        flyway.migrate();
    }
}
