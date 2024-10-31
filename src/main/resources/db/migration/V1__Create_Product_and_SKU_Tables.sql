CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(256) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    active BOOLEAN NOT NULL,
    start_date DATE
    );

CREATE TABLE IF NOT EXISTS sku (
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES product(id),
    sku_code VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP
    );
