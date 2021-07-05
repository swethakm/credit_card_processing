# credit_card_processing
 credit card processing API

## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.4.8

## Requirements:
The `REST` service must expose the `/creditcards` endpoint, which allows for managing the credit card data records in the following way:


`POST` request to `/add` :
* creates a new credit card data record
* the response code is 201 and the response body is the created record, including its unique cardNumber
* It should also validate given unique cardNumber using Luhn 10 algorithm


`GET` request to `/list`:
* the response code is 200
* the response body is an array of all credit card records in DB


## Commands
- run: 
```bash
mvn clean package; java -jar target/credit_card_processing-0.0.1-SNAPSHOT.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```