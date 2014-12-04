ProductStock
============

Quick API to manage stock. It uses an in memory database, so all you changes will be lost every time the process is stoped, to avoid this, please configure the Application file with your DataSource.

Installation
------------

1. To use this program, please download the source code, for example using git:

  ```bash
  git clone --depth 1 git@github.com:maduxi/ProductStock.git
  ```
2. Compile. This Stock control API can be deployed as a WAR, but it's currently configured to generate an executable jar, that runs a tomcat.

  Enter into the project folder and compile it using maven:
  ```bash
  mvn clean package
  ```
3. Run it. Make sure the port 8080 is free.

  ```bash
  java -jar target/Stock-API-0.1.0.jar
  ```  
You should be able to access the application usign http://localhost:8080

Usage
-----

The best way to learn how to use it, is to try its features.

- Add a product
  To add a product, you need to provide a  valid JSON representing it. This is a sample request that would create a product:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{
  "name": "TV Phillips 28",
  "description":"desc",
  "category":"TV"
  }' http://localhost:8080/product
  ```
  The reply is the product recently created, but with the asigned id.
  
- Find a product by id
  Request a product by its id. A sample request is:
  ```bash
  curl -X GET http://localhost:8080/product/2
  ```

- Edit a product
  Sends a new version of the product.
  ```bash
  curl -X PUT -H "Content-Type: application/json" -d '{
    "id": 2,
    "name": "TV Phillips 39",
    "description": "desc",
    "category": "TV"
  }' http://localhost:8080/product
  ```
- Delete a product

  Deletes a product by id. An example:

  ```bash
  curl -X DELETE http://localhost:8080/product/2
  ```
- List all products

  Gets a list of all the available products. 

  ```bash
  curl -X GET http://localhost:8080/product
  ```
  - List all products by category
  
    ```bash
    curl -X GET http://localhost:8080/product?category=TV
    ```
TEST
---
To test the API, with the project can be found a Postman collection, that can be run to check the proper behaviour of the system:

https://github.com/maduxi/ProductStock/blob/master/TestStock.json.postman_collection
