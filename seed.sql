-- Seed data for development/testing

BEGIN TRANSACTION;

-- Basic users (note: passwords are plain text for demo only)
INSERT INTO login (username, password, division) VALUES ('admin', 'admin', 'Admin');
INSERT INTO login (username, password, division) VALUES ('student', 'student', 'Student');

-- Sample students
INSERT INTO students (id, fname, lname, email, DOB, Age, AverageGrade) VALUES ('S001', 'John', 'Doe', 'john.doe@example.com', '2006-04-12', 17, '85');
INSERT INTO students (id, fname, lname, email, DOB, Age, AverageGrade) VALUES ('S002', 'Jane', 'Smith', 'jane.smith@example.com', '2005-08-30', 18, '92');
INSERT INTO students (id, fname, lname, email, DOB, Age, AverageGrade) VALUES ('S003', 'Ali', 'Khan', 'ali.khan@example.com', '2007-01-15', 16, '78');

COMMIT;
