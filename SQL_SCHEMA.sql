CREATE DATABASE IF NOT EXISTS taxi_service;
USE taxi_service;

CREATE TABLE Client (
    clientID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE Driver (
    driverID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    licenseNo VARCHAR(50),
    rating DOUBLE,
    active BOOLEAN
);

CREATE TABLE Car (
    carID INT AUTO_INCREMENT PRIMARY KEY,
    plate VARCHAR(20),
    carType VARCHAR(50),
    color VARCHAR(30),
    seats INT,
    driverID INT,
    FOREIGN KEY (driverID) REFERENCES Driver(driverID)
);

CREATE TABLE Tariff (
    tariffID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    basePrice DOUBLE,
    pricePerKm DOUBLE,
    active BOOLEAN
);

CREATE TABLE Service (
    serviceID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(255),
    effectType VARCHAR(20),
    effectValue DOUBLE,
    isPercent BOOLEAN
);

CREATE TABLE `Order` (
    orderID INT AUTO_INCREMENT PRIMARY KEY,
    clientID INT,
    driverID INT,
    carID INT,
    tariffID INT,
    pickup VARCHAR(100),
    dropoff VARCHAR(100),
    distance DOUBLE,
    createdAt DATETIME DEFAULT NOW(),
    FOREIGN KEY (clientID) REFERENCES Client(clientID),
    FOREIGN KEY (driverID) REFERENCES Driver(driverID),
    FOREIGN KEY (carID) REFERENCES Car(carID),
    FOREIGN KEY (tariffID) REFERENCES Tariff(tariffID)
);

CREATE TABLE Receipt (
    receiptID INT AUTO_INCREMENT PRIMARY KEY,
    orderID INT,
    basePrice DOUBLE,
    extrasPrice DOUBLE,
    discount DOUBLE,
    finalPrice DOUBLE,
    generatedAt DATETIME DEFAULT NOW(),
    FOREIGN KEY (orderID) REFERENCES `Order`(orderID)
);
