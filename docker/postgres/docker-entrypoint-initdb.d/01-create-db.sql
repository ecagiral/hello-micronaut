
-- Create a database based on the project name
CREATE DATABASE hello_micronaut;

--create uuid extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create the admin user
CREATE USER hello_admin WITH PASSWORD 'admin';

ALTER USER hello_admin WITH SUPERUSER;

GRANT ALL PRIVILEGES ON DATABASE hello_micronaut TO hello_admin;

\connect hello_micronaut hello_admin

--create uuid extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create product table
CREATE TABLE product (
    uuid UUID NOT NULL DEFAULT uuid_generate_v4(),
    display_name character varying(255)
);
ALTER TABLE product ADD CONSTRAINT product_uuid_pkey PRIMARY KEY (uuid);

-- Populate table
INSERT INTO product(display_name) values ('test_1'),('test_2');