DROP TABLE IF EXISTS BANK_ACCOUNT;
DROP TABLE IF EXISTS BANK_USER;
CREATE TABLE IF NOT EXISTS BANK_USER (
                           id SERIAL PRIMARY KEY,
                           username VARCHAR(255),
                           password VARCHAR(255)
);

ALTER TABLE BANK_USER DROP CONSTRAINT IF EXISTS unique_username;
ALTER TABLE BANK_USER ADD CONSTRAINT unique_username UNIQUE (username);

CREATE TABLE IF NOT EXISTS BANK_ACCOUNT (
                              id SERIAL PRIMARY KEY,
                              currency VARCHAR(255),
                              balance NUMERIC(38, 2),
                              user_id BIGINT REFERENCES BANK_USER(id)
);
