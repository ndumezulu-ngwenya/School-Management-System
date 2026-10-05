-- Schema for School Management System

PRAGMA foreign_keys = OFF;
BEGIN TRANSACTION;

-- Login table
CREATE TABLE IF NOT EXISTS login (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  username TEXT NOT NULL UNIQUE,
  password TEXT NOT NULL,
  division TEXT NOT NULL
);

-- Students table
CREATE TABLE IF NOT EXISTS students (
  id TEXT PRIMARY KEY,
  fname TEXT,
  lname TEXT,
  email TEXT,
  DOB TEXT,
  Age INTEGER,
  AverageGrade TEXT
);

COMMIT;
