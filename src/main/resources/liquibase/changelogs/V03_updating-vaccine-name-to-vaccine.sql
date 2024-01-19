--liquibase formatted sql

--changeset 20240118-1 author:luisgustavobsilva@gmail.com label:updating-vaccine-name-to-vaccine

ALTER TABLE vaccines RENAME COLUMN name TO vaccine;

-- rollback ALTER TABLE vaccines DROP COLUMN iban;