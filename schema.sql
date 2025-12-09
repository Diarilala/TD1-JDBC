CREATE TABLE Product(
    id int PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    price DECIMAL,
    creation_datetime timestamp
);

CREATE TABLE Product_category(
    id int PRIMARY KEY NOT NULL,
    name VARCHAR,
    product_id int FOREIGN KEY REFERENCES Product(id)
);