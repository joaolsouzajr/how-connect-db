# how-connect-db
How connect database in many programing languages

## Databases

A database is an organized collection of data. The system objective is to improve read, write and processing about the
data. I consider the data are most important object on software solutions. Many applications use database. So, is very
important to know how to access data from databases using programing laguagens.

Exists many database vendors, open source and commercial/closed source.

Open source

* [PostgreSQL](http://www.postgresql.org/)
* [Mysql Community](https://dev.mysql.com/downloads/mysql/)
* [Sqlite3](https://www.sqlite.org/)
* [Outros]()

Comercial

* [Oracle](https://www.oracle.com/database/)
* [SQL Server](https://pt.wikipedia.org/wiki/Microsoft_SQL_Server)
* [Sybase](https://pt.wikipedia.org/wiki/Sybase)
* Outros


## Install Database

In this tutorial I use PostgreSQl

#### Install PostgreSQL

On Linux Red Hat fammily:

        sudo dnf install postgresql-server postgresql-contrib
        sudo postgresql-setup initdb
        sudo systemctl enable postgresql.service
        sudo systemctl start postgresql.service

Others ways to install see [PostgreSQL site](http://www.postgresql.org/download/).
#### Configure PostgreSQL

1. Open file /etc/postgresql/9.4/main/pg_hba.conf,
search session "IPv4 local connections" and alter to:

        # IPv4 local connections:
        host    all    all    0.0.0.0/0  md5

2. Open file /etc/postgresql/9.4/main/postgresql.conf,
search session  "# - Connection Settings" and alter to:

        # - Connection Settings –
        listen_addresses = '*'  # what IP address(es) to listen on;

3. Restart service

        sudo systemctl stop postgresql.service
        sudo systemctl start postgresql.service

#### Create database

        --create dtabase and users
        CREATE USER storedba WITH PASSWORD 'dba@2573';
        CREATE USER storeapp WITH PASSWORD 'app@2573';
        CREATE DATABASE store OWNER storedba;
        GRANT ALL PRIVILEGES ON DATABASE store to storedba;
        GRANT ALL PRIVILEGES ON DATABASE store to storeapp;

        --create tables
        CREATE TABLE product (id BIGINT, name VARCHAR(255) NOT NULL, CONSTRAINT product_pk PRIMARY KEY (id));

        --insseer data
        INSERT INTO product (id, name) VALUES (1, 'tablet');
        INSERT INTO product (id, name) VALUES (2, 'notebook');
        INSERT INTO product (id, name) VALUES (3, 'Tv');
        INSERT INTO product (id, name) VALUES (4, 'smartphone');


## How to connect from Java


### JDBC
### Hibernate
### Spring JDBC Template


## How to connect from C++

## How to connect from C#

## How To connect from Groovy

## How To connect from Python

## How To connect from Ruby

## How to connect from LabVIEW




## References

1. (Databases)[https://en.wikipedia.org/wiki/Database]
2. (Install PostgreSQL)[http://www.postgresql.org/download/]
