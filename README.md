# BankingAccount
Zad Banking Account Project

## Installation

### Prerequisites
- **Docker**
- **Docker Compose**

1. Clone this repository:
   ```sh
   git clone https://github.com/sorbaciemre/BankingAccount.git
   cd BankingAccount

2. Download the necessary dependencies and build the application
   ```sh
    docker-compose up --build

### Swagger Documentation

#### Endpoint

- **URL**: `http://localhost:8080/webjars/swagger-ui/swagger-ui/index.html#/`


#### Example users, Database entries and Schema
(App operations must be performed according to the data defined below.)
   ```sh
    INSERT INTO BANK_USER (username, password) VALUES
        ('user1', '1234'),
        ('user2', '1234'),
        ('user3', '1234'),
        ('user4', '1234');
    INSERT INTO BANK_ACCOUNT (currency, balance, user_id) VALUES
        ('USD', 1000.00, 1),
        ('TRY', 1000.00, 1),
        ('USD', 1000.00, 2),
        ('TRY', 1000.00, 2),
        ('USD', 1000.00, 3),
        ('TRY', 1000.00, 3),
        ('USD', 2000.00, 4),
        ('TRY', 2000.00, 4);
        
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