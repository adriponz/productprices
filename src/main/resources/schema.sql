CREATE TABLE prices (
    product_id INT NOT NULL,
    brand_id INT NOT NULL,
    price DOUBLE,
    currency VARCHAR(5),
    price_list_id INT NOT NULL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    priority INT,

    PRIMARY KEY (product_id, brand_id, price_list_id)
);