CREATE TABLE IF NOT EXISTS quantity_measurement_entity (

    id INT AUTO_INCREMENT PRIMARY KEY,

    operand1 VARCHAR(50),
    operand2 VARCHAR(50),

    measurement_type VARCHAR(30),

    operation_type VARCHAR(30),

    result_value VARCHAR(50),

    error_flag BOOLEAN,

    message VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);