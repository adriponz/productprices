DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
    product_id BIGINT NOT NULL,
    brand_id BIGINT NOT NULL,
    price DOUBLE NOT NULL,
    currency VARCHAR(5) NOT NULL,
    price_list_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    priority INT NOT NULL,
    last_update TIMESTAMP,
    last_update_by VARCHAR(20) NOT NULL,

    PRIMARY KEY (product_id, brand_id, price_list_id)
);