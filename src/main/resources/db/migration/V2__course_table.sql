DROP TABLE IF EXISTS Course;

CREATE TABLE IF NOT EXISTS Course (
    CourseID SERIAL PRIMARY KEY, -- Auto-incrementing unique ID
    CourseName VARCHAR(100) NOT NULL,
    Credits INT NOT NULL CHECK (Credits > 0)
);