--liquibase formatted sql

--changeset 20240116-1 author:luisgustavobsilva@gmail.com label:create-schema

ALTER TABLE vaccines ADD COLUMN iban VARCHAR(42);

-- rollback ALTER TABLE vaccines DROP COLUMN iban;