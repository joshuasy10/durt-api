DELIMITER $$
DROP PROCEDURE IF EXISTS seeder_script $$
CREATE PROCEDURE seeder_script()
BEGIN
	START TRANSACTION;
    
    -- Inserting data into the employees table
INSERT INTO delivery_employees (name, salary, national_insurance_number, bank_account_number)
VALUES
  ('John Doe', 50000, 'AB34567891C', '0284714819'),
  ('Jane Smith', 60000, 'CD7654321V', '1324714819'),
  ('Alice Johnson', 55000, 'DJ678912P', '0187314819'),
  ('Gordon Davidson', 55000, 'DM386623P', '0183628394'),
  ('Adam Brown', 55000, 'DF679252D', '3678254729'),
  ('Harry Bacon', 55000, 'CF679252D', '6732712111');


INSERT INTO sales_employees (name, salary, national_insurance_number, bank_account_number, commission_rate)
VALUES
  ('Borris Banner', 50000, '1B34567891C', '0284714819', 0.01),
  ('Jack Larsen', 60000, '2D7654321V', '1324714819', 0.02),
  ('Abbey Dorris', 55000, '3J678912P', '0187314819', 0.03),
  ('Gillean Mavis', 55000, '4M386623P', '0183628394' ,0.02),
  ('Andrew Black', 55000, '5F679252D', '3678254729', 0.02),
  ('Julian Jackson', 55000, '6F679252D', '6732712111', 0.04);





-- Inserting data into the clients table
INSERT INTO clients (name, address, phone, sales_employee_id, lead_employee_id, joined_at)
VALUES
  ('ABC Company', '123 Main St, Anytown', '555-1234', 1, 1, '2020-04-12 10:00:00'),
  ('XYZ Corporation', '456 Elm St, Othertown', '555-5678', 1, 2, '2023-04-12 10:00:00'),
  ('Acme Inc.', '789 Oak St, Anothertown', '555-9012', 2, 2, '2021-04-12 10:00:00'),
  ('Global Enterprises', '321 Pine St, Somewhere', '555-3456', 3, 1, '2020-04-12 10:00:00'), 
  ('Tech Solutions', '987 Maple St, Overthere', '555-7890', 3, 3, '2020-05-12 10:00:00'),
  ('Innovative Industries', '654 Cedar St, Outoftown', '555-2345', 5, 1, '2020-04-12 10:00:00');

-- Inserting data into the projects table
INSERT INTO projects (client_id, name, value, technologies, completed_at, lead_employee_id)
VALUES
  (1, 'Project A', 1000000, 'Java, SQL', '2023-06-15 10:00:00', 4),
  (2, 'Project B', 2000000, 'Python, HTML', NULL, 4),
  (3, 'Project C', 1500000, 'C#, MySQL', '2023-06-30 15:30:00', 5),
  (4, 'Project D', 3000000, 'JavaScript, CSS', NULL, 5),
  (4, 'Project E', 3500000, 'JavaScript, CSS', NULL, 5);

-- Inserting data into the project_employees table
INSERT INTO project_employees (project_id, delivery_employee_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (2, 3),
  (3, 4),
  (4, 1),
  (4, 3),
  (4, 4),
  (4, 5);

-- Inserting data into the project_employee_logs table
INSERT INTO project_employee_logs (project_id, delivery_employee_id, left_at)
VALUES
  (1, 1, '2023-06-20 12:00:00'),
  (1, 2, '2023-06-21 14:30:00'),
  (2, 1, '2023-06-19 11:45:00'),
  (3, 4, '2023-06-25 09:15:00');

-- check the number of affected rows
	GET DIAGNOSTICS @rows = ROW_COUNT;
	IF @rows = 0 THEN
		-- Rollback if error
		ROLLBACK;
		SELECT 'Transaction rolled back due to an error.';
	ELSE
		-- If error free
		COMMIT;
		SELECT 'Transaction committed successfully.';
	END IF; 
	
END $$
DELIMITER ;
CALL seeder_script();		