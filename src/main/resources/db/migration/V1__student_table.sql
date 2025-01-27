DROP TABLE IF EXISTS Student;

CREATE TABLE IF NOT EXISTS Student (
    StudentID SERIAL PRIMARY KEY, -- Auto-incrementing unique ID
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(150) UNIQUE NOT NULL
);