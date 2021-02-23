package com.yaichnikovd.d2;

import com.yaichnikovd.d2.migrator.Migrator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UserServiceDbMigrationApplication implements CommandLineRunner {

    private static final String ARG_MIGRATE = "--migrate";
    private static final String ARG_CLEAN = "--clean";

    private final Migrator migrator;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceDbMigrationApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        final String arg = args[0];

        switch (arg) {
            case ARG_MIGRATE:
                migrator.migrate();
                break;
            case ARG_CLEAN:
                migrator.clean();
                break;
            default:
                throw new IllegalArgumentException("Unsupported argument provided");
        }
    }
}
