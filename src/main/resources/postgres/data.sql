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


INSERT INTO pizza(ingredients, name, price, cost, gluten_free, vegetarian, vegan)
    VALUES
        (ARRAY ['Tomato', 'Mozzarella', 'Salami', 'Pizza Dough'], 'Salami Pizza', 6.95, 2.15, 'f', 'f', 'f'),
        (ARRAY ['Tomato', 'Mozzarella', 'Fennel Sausage', 'Caramelised Onion'], 'Fennel Sausage Pizza', 7.95, 2.40, 'f', 'f', 'f'),
        (ARRAY ['Tomato', 'Mozzarella', 'Pepperoni', 'Pizza Dough'], 'Pepperoni Pizza', 6.95, 2.15, 'f', 'f', 'f');

INSERT INTO drinks(alcoholic, cost, gluten_free, name, vegetarian, vegan)
    VALUES
    ('f', 1.00, 't', 'Coke', 't', 't'),
    ('f', 1.00, 't', 'Lemonade', 't', 't'),
    ('f', 1.00, 't', 'Fanta', 't', 't'),
    ('t', 1.59, 'f', 'Lager', 't', 't'),
    ('t', 1.59, 'f', 'IPA', 't', 't'),
    ('t', 1.59, 't', 'Cider', 't', 't');