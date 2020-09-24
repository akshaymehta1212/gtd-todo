DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS todoitems;

CREATE TABLE users(
    uid NUMERIC AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL

);

CREATE TABLE todoitems (
  task_id NUMERIC AUTO_INCREMENT  PRIMARY KEY,
  priority VARCHAR(250) CHECK (priority in ('Low','Medium','High'))  AND NOT NULL ,
  task_name VARCHAR(250) NOT NULL,
  task_details VARCHAR(250) NOT NULL,
  created_on DATE DEFAULT NULL,
  is_done BOOLEAN ,
  last_updated DATE,
  user_id NUMERIC,
  FOREIGN KEY (user_id) REFERENCES users(uid)
);


