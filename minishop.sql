DROP database if exists minishop;
CREATE database minishop;
CREATE TABLE minishop.customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50)
);
CREATE TABLE minishop.orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES minishop.customers(id)
);
use minishop;

INSERT INTO minishop.customers (name, email) VALUES
    ('John Doe', 'john@example.com'),
    ('Jane Smith', 'jane@example.com'),
    ('Mike Johnson', 'mike@example.com'),
    ('Charlie Brown', 'charlie@example.com'),
    ('Emily Davis', 'emily@example.com');

INSERT INTO minishop.orders (customer_id, order_date) VALUES
    (1, '2023-03-15'),
    (2, '2023-03-16'),
    (1, '2023-03-17'),
    (3, '2023-03-18'),
    (2, '2023-03-19'),
    (4, '2023-03-20'),
    (3, '2023-03-20'),
    (5, '2023-03-21');



