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

