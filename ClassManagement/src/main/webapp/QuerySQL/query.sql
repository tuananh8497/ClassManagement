USE master
DROP DATABASE MorkProject
CREATE DATABASE MorkProject
USE MorkProject

CREATE TABLE Position(
    id INT IDENTITY(1, 1),
    [Name] VARCHAR(20),
    PRIMARY KEY (id)
)

CREATE TABLE Course(
    ID INT IDENTITY(1, 1),
    [Name] VARCHAR(20),
    PRIMARY KEY(ID)
)

CREATE TABLE Class(
    Account VARCHAR(10) NOT NULL,
    [Name] VARCHAR(20) NOT NULL,
    AdminAccount VARCHAR(10),
    StartTime DATE NOT NULL,
    CourseID INT NOT NULL FOREIGN KEY REFERENCES Course(ID),
    EndTimeExpected DATE NOT NULL,
    EndTimeReality DATE DEFAULT NULL,
    PRIMARY KEY (Account)
)

CREATE TABLE Person(
    Account VARCHAR(10) NOT NULL,
    [Name] VARCHAR(20) NOT NULL,
    DateOfBirth DATE ,
    Position INT NOT NULL FOREIGN KEY REFERENCES Position(id),
    AdminAccount VARCHAR(10) FOREIGN KEY REFERENCES Person(Account),
    ClassAccount VARCHAR(10) FOREIGN KEY REFERENCES Class(Account),
    PRIMARY KEY (Account)
)
GO


CREATE TABLE [Subject](
    ID INT IDENTITY(1, 1),
    [Name] VARCHAR(20),
    PRIMARY KEY (ID)    
)

CREATE TABLE [Point](
    PersonID VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Person(Account),
    SubjectID INT NOT NULL,
    [Point] FLOAT,
    PRIMARY KEY (PersonID) 
)

CREATE TABLE Mentor(
    Account VARCHAR(10),
    [Name] VARCHAR(20),
    PRIMARY KEY (Account)
)

CREATE TABLE Calendar(
    CourseID INT NOT NULL FOREIGN KEY REFERENCES Course(ID),
    SubjectID INT NOT NULL FOREIGN KEY REFERENCES [Subject](ID),
    Duration INT NOT NULL,
    Priority INT NOT NULL,
    MentorAccount VARCHAR(10) NOT NULL FOREIGN KEY REFERENCES Mentor(Account)
    PRIMARY KEY (CourseID, SubjectID)
)

CREATE TABLE Checked(
    Account VARCHAR(10) NOT NULL,
    [Date] DATE,
    PRIMARY KEY(Account) 
)
