package com.d2.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
public class Config {

    private static final String LOCAL_PROFILE = "local";

    private final Environment env;
    private final String url;
    private final String user;
    private final String password;
    private final String schema;

    public Config(final Environment env,
                  @Value("${db.url}") final String url,
                  @Value("${db.user}") final String user,
                  @Value("${db.password}") final String password,
                  @Value("${db.schema}") final String schema) {
        this.env = env;
        this.url = url;
        this.user = user;
        this.password = password;
        this.schema = schema;
    }

    @Bean
    public Flyway flyway() {
        return Flyway.configure()
                .dataSource(url, user, password)
                .schemas(schema)
                .createSchemas(true)
                .cleanOnValidationError(cleanOnValidationError())
                .cleanDisabled(!cleanOnValidationError())
                .load();
    }

    private boolean cleanOnValidationError() {
        return Set.of(env.getActiveProfiles()).contains(LOCAL_PROFILE);
    }
}
