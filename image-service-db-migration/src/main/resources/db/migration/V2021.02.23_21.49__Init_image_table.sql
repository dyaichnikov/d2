create table IMAGES (
    ID uuid primary key,
    USER_ID uuid not null,
    BUCKET text not null,
    OBJECT_PATH text not null,
    DESCRIPTION text not null
);
