--liquibase formatted sql

--changeset rheller:2023-day1
CREATE SCHEMA IF NOT EXISTS "2023.day1";
CREATE TABLE "2023.day1".calibration_value (
    id SERIAL PRIMARY KEY,
    "value" VARCHAR NOT NULL
);
--rollback DROP SCHEMA "2023.day1" CASCADE;

--changeset rheller:2023-day2
CREATE SCHEMA IF NOT EXISTS "2023.day2";
CREATE TABLE "2023.day2".game (
    id SERIAL PRIMARY KEY,
    "number" INTEGER NOT NULL UNIQUE
);
CREATE TABLE "2023.day2".round (
    id SERIAL PRIMARY KEY,
    game_id INTEGER REFERENCES "2023.day2".game (id),
    red INTEGER NOT NULL DEFAULT 0,
    blue INTEGER NOT NULL DEFAULT 0,
    green INTEGER NOT NULL DEFAULT 0
);
--rollback DROP SCHEMA "2023.day2" CASCADE;
