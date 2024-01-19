CREATE TABLE images
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    path        TEXT                        NOT NULL,
    description VARCHAR(2200),
    upload_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_id     UUID                        NOT NULL
);