## Introduction

As part of our project:"Advanced Object Programming", we have to develop a vehicle sales application.

## Technology Stack

- `Maven` 
- `JavaFX` 
- `SpringBoot` ----version 2.7.4
- `Mysql` ----version 8.0.30
- `Mybatis-Plus` ----version 3.5.2

### Requirement
Please ensure that your jdk version is higher than 13 and that the JAVAFX module is included.

## Quick Start
GitHub Address：
https://github.com/CHENZhoujing/Java_Projet_M1.git


First, create a database using the gvv.sql in the Database folder.

Second, change the url, username and password of your database in application.yml

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gvv?serverTimezone=UTC
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

Then, execute the following commands.

```shell
mvn clean package
cd target
java -jar Java_Projet_M1-0.0.1-SNAPSHOT.jar
```

## Default Login Credentials
| Username      | Password      |
|---------------|---------------|
| admin         | 11111111      |
| userA         | 11111111      |

## List of authors
CHENZhoujing & DONGZiqing

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
