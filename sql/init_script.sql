DELIMITER $$
DROP PROCEDURE IF EXISTS init_script $$
CREATE PROCEDURE init_script()
BEGIN
	START TRANSACTION;



	CREATE TABLE IF NOT EXISTS delivery_employees (
        		id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        		name VARCHAR(50) NOT NULL,
        		salary INT UNSIGNED NOT NULL,
        		national_insurance_number VARCHAR(9) NOT NULL
        	);

    CREATE TABLE IF NOT EXISTS sales_employees (
            id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(50) NOT NULL,
            salary INT UNSIGNED NOT NULL,
            national_insurance_number VARCHAR(9) NOT NULL
        );


    CREATE TABLE IF NOT EXISTS delivery_employees (
            id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
             SMALLINT UNSIGNED NOT NULL,
            FOREIGN KEY (employee_id) REFERENCES employees(id)
        );




	CREATE TABLE IF NOT EXISTS delivery_employees (
        id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        salary DECIMAL UNSIGNED NOT NULL,
        national_insurance_number VARCHAR(9) NOT NULL,
        bank_account_number VARCHAR(10) NOT NULL
    );

    CREATE TABLE IF NOT EXISTS sales_employees (
        id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        salary DECIMAL UNSIGNED NOT NULL,
        national_insurance_number VARCHAR(9) NOT NULL,
        bank_account_number VARCHAR(10) NOT NULL,
        commission_rate FLOAT UNSIGNED NOT NULL
    );


    

	-- part three (client table)

	CREATE TABLE IF NOT EXISTS clients (
		id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		name VARCHAR(50) NOT NULL,
		address VARCHAR(255) NOT NULL,
		phone VARCHAR(11) NOT NULL,
		sales_employee_id SMALLINT UNSIGNED NOT NULL,
		lead_employee_id SMALLINT UNSIGNED NOT NULL,
		joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


		FOREIGN KEY (sales_employee_id) REFERENCES sales_employees(id),
		FOREIGN KEY (lead_employee_id) REFERENCES delivery_employees(id)
	);

	CREATE TABLE IF NOT EXISTS projects (
	id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	client_id SMALLINT UNSIGNED NOT NULL,
	name VARCHAR(50) NOT NULL,
	value DECIMAL UNSIGNED NOT NULL,
	technologies TEXT,
	started_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	completed_at TIMESTAMP,
	lead_employee_id SMALLINT UNSIGNED NOT NULL,

	FOREIGN KEY (client_id) REFERENCES clients(id),
	FOREIGN KEY (lead_employee_id) REFERENCES delivery_employees(id)

	);        
			
	CREATE TABLE IF NOT EXISTS project_employees (
	project_id SMALLINT UNSIGNED NOT NULL,
	delivery_employee_id SMALLINT UNSIGNED NOT NULL,
	joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	CONSTRAINT pk_project_employee PRIMARY KEY (project_id, delivery_employee_id),
	FOREIGN KEY (project_id) REFERENCES projects(id),
	FOREIGN KEY (delivery_employee_id) REFERENCES delivery_employees(id)
	);     
			
	CREATE TABLE IF NOT EXISTS project_employee_logs (
	project_id SMALLINT UNSIGNED NOT NULL,
	delivery_employee_id SMALLINT UNSIGNED NOT NULL,
	joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	left_at TIMESTAMP,

	CONSTRAINT pk_project_employee PRIMARY KEY (project_id, delivery_employee_id),
	FOREIGN KEY (project_id) REFERENCES projects(id),
	FOREIGN KEY (delivery_employee_id) REFERENCES delivery_employees(id)
	);       

	
	
END $$
DELIMITER ;
CALL init_script();			