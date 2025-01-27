DROP TABLE IF EXISTS Enrollment;

CREATE TABLE IF NOT EXISTS Enrollment (
    EnrollmentID SERIAL PRIMARY KEY, -- Optional unique identifier
    StudentID INT NOT NULL,         -- Foreign key referencing Student
    CourseID INT NOT NULL,          -- Foreign key referencing Course
    EnrollmentDate DATE DEFAULT CURRENT_DATE, -- When the student enrolled
    CONSTRAINT fk_student FOREIGN KEY (StudentID) REFERENCES Student (StudentID) ON DELETE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (CourseID) REFERENCES Course (CourseID) ON DELETE CASCADE,
    CONSTRAINT unique_student_course UNIQUE (StudentID, CourseID) -- Prevent duplicate enrollments
);