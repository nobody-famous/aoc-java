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

--changeset rheller:2023-day3
CREATE SCHEMA IF NOT EXISTS "2023.day3";
CREATE TABLE "2023.day3"."number" (
    id SERIAL PRIMARY KEY,
    y INTEGER NOT NULL,
    start_x INTEGER NOT NULL,
    end_x INTEGER NOT NULL,
    "value" INTEGER NOT NULL
);
CREATE TABLE "2023.day3".symbol (
    id SERIAL PRIMARY KEY,
    y INTEGER NOT NULL,
    x INTEGER NOT NULL,
    "value" CHAR NOT NULL
);
--rollback DROP SCHEMA "2023.day3" CASCADE;

--changeset rheller:2023-day4
CREATE SCHEMA IF NOT EXISTS "2023.day4";
CREATE TABLE "2023.day4"."card" (
    id SERIAL PRIMARY KEY,
    "number" INTEGER NOT NULL,
    copies INTEGER DEFAULT 1,
    wins INTEGER DEFAULT 0
);
CREATE TABLE "2023.day4".winning (
    id SERIAL PRIMARY KEY,
    card_id INTEGER REFERENCES "2023.day4"."card" (id),
    "number" INTEGER NOT NULL
);
CREATE TABLE "2023.day4".holding (
    id SERIAL PRIMARY KEY,
    card_id INTEGER REFERENCES "2023.day4"."card" (id),
    "number" INTEGER NOT NULL
);
--rollback DROP SCHEMA "2023.day4" CASCADE;
