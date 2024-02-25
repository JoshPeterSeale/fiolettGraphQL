INSERT INTO ingredients(name, cost, gluten_free, vegetarian, vegan)
    VALUES
    ('Pizza Dough', 0.20, 'f', 't', 't'),
    ('Fennel Sausage', 0.75, 't', 'f', 'f'),
    ('Caramelised Onion', 0.30, 't', 't', 'f'),
    ('Red Onion', 0.15, 't', 't', 't'),
    ('Salami', 0.80, 't', 'f', 'f'),
    ('Pepperoni', 0.80, 't', 'f', 'f'),
    ('Tomato', 0.40, 't', 't', 't'),
    ('Mozzarella', 0.75, 't', 't', 'f');

INSERT INTO drinks(alcoholic, cost, gluten_free, name, vegetarian, vegan)
    VALUES
    ('f', 1.00, 't', 'Coke', 't', 't'),
    ('f', 1.00, 't', 'Lemonade', 't', 't'),
    ('f', 1.00, 't', 'Fanta', 't', 't'),
    ('t', 1.59, 'f', 'Lager', 't', 't'),
    ('t', 1.59, 'f', 'IPA', 't', 't'),
    ('t', 1.59, 't', 'Cider', 't', 't');

INSERT INTO customer(first_name, last_name, email_address, number_of_orders)
    VALUES
    ('Alessandra', 'James', 'alessandrajames@hotmail.co.uk', 0),
    ('Josh', 'Seale', 'josh.seale@outlook.co.uk', 0);