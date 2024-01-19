CREATE TABLE users
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(50)                 NOT NULL,
    last_name  VARCHAR(50)                 NOT NULL,
    email      VARCHAR(3200)               NOT NULL,
    reg_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL
);