INSERT INTO brand(brand_name) VALUES ('Nike');
INSERT INTO brand(brand_name) VALUES ('Adidas');
INSERT INTO brand(brand_name) VALUES ('Puma');

INSERT INTO category(category_name) VALUES ('Molinete');
INSERT INTO category(category_name) VALUES ('Vara');
INSERT INTO category(category_name) VALUES ('Anzol');
INSERT INTO category(category_name) VALUES ('Linha');

INSERT INTO product(product_name, price_in_cents, quantity, description, brand_id, category_id) VALUES ('Vara de pescar de irídio', 2000, 7, 'The best fishroad of the Pelican Town', 1, 2);
INSERT INTO product(product_name, price_in_cents, quantity, description, brand_id, category_id) VALUES ('Anzol pegatudo', 500, 9, 'Fish bait that increases the chance of getting a fish', 3, 3);
