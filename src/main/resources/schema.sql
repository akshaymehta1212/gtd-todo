DROP TABLE IF EXISTS todoitems;

CREATE TABLE todoitems (
  task_id NUMERIC AUTO_INCREMENT  PRIMARY KEY,
  task_type VARCHAR(250) NOT NULL,
  task_name VARCHAR(250) NOT NULL,
  task_details VARCHAR(250) NOT NULL,
  created_on DATE DEFAULT NULL,
  is_done BOOLEAN 
);