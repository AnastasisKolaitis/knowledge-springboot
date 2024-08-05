CREATE TABLE schools (
    id SERIAL PRIMARY KEY,
    schoolName VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    AM VARCHAR(255),
    school_id INTEGER REFERENCES schools(id)
);
