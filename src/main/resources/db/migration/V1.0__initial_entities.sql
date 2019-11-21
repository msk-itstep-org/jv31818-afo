CREATE TABLE demo_honeywell.users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25) NOT NULL UNIQUE,
  email VARCHAR(25) NOT NULL UNIQUE,
  password VARCHAR(25)
);

CREATE TABLE demo_honeywell.devices (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  device_desc VARCHAR(255) NOT NULL,
  device_sku VARCHAR(25) UNIQUE,
  device_sn VARCHAR(25) UNIQUE,
  archived_devices INT,
  user_id INT,
  CONSTRAINT user_id_devices_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE demo_honeywell.loans (
  id INT PRIMARY KEY AUTO_INCREMENT,
  loan_desc VARCHAR(255) NOT NULL,
  start_date DATE,
  days_quantity INT,
  loaned INT,
  user_id INT,
  device_id INT,
  CONSTRAINT user_id_loans_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL,
  CONSTRAINT device_id_loans_fk FOREIGN KEY (device_id) REFERENCES devices (id) ON UPDATE SET NULL ON DELETE SET NULL
);