--liquibase formatted sql

--changeset rheller:2023-day1
CREATE SCHEMA IF NOT EXISTS "2023.day1";
CREATE TABLE "2023.day1".calibration_value (
    id SERIAL PRIMARY KEY,
    "value" VARCHAR NOT NULL
);
--rollback DROP SCHEMA "2023.day1" CASCADE;
