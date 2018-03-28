CREATE TABLE tweets (
id BIGINT PRIMARY KEY,
date DATE,
hour TIME,
message VARCHAR,
favs BIGINT,
rts BIGINT,
picture VARCHAR,
lang VARCHAR,
url VARCHAR,
listed BIGINT,
CONSTRAINT uname FOREIGN KEY (uname) REFERENCES users(uname),
CONSTRAINT location FOREIGN KEY (locationId) REFERENCES locations(locationId)
);

CREATE TABLE users(
uname VARCHAR PRIMARY KEY,
nickname VARCHAR,
bio VARCHAR,
followers BIGINT,
following BIGINT
);

CREATE TABLE locations(
locationId BIGINT PRIMARY KEY,
latitude DOUBLE PRECISION,
longitude DOUBLE PRECISION,
CONSTRAINT country FOREIGN KEY (countryId) REFERENCES countries(countryId)
);

CREATE TABLE countries ( 
countryId BIGINT PRIMARY KEY, 
country VARCHAR
place VARCHAR
);
