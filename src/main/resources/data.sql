DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS customers;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

INSERT INTO employees (first_name, last_name, mail, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');


  CREATE TABLE customers (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL,
    birthDate DATE NOT NULL
  );

INSERT INTO customers (firstName, lastName, birthDate) VALUES
  ('Toto', 'TOTO', '1990-01-02'),
  ('Tata', 'TATA', '1993-02-03'),
  ('Titi', 'TITI', '1995-03-04');