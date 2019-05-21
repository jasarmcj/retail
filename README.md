
Retail Spring Boot Application
==============================

The Retail application is developed using Spring Boot. In-memory H2 database is used for storing data. 
The database and objects are created when starting the application. 
The test data in given as sql insert statement which will be executed during start-up.

1.	If the user is an employee of the store, he gets a 30% discount
2.	If the user is an affiliate of the store, he gets a 10% discount
3.	If the user has been a customer for over 2 years, he gets a 5% discount.
4.	For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
5.	The percentage-based discounts do not apply on groceries.
6.	A user can get only one of the percentage-based discounts on a bill.


The application is designed and developed by considering below points

1.	Object oriented programming approach. 
2.	Test driven development
3.	Simple and generic coding best practices conventions 


Completed the below points

•	Working application which is available in GIT - https://github.com/jasarmcj/retail.git
•	High level design diagrams including class diagram
•	Code coverage of junits test. Coverage report is generated JACOCO which is integrated along with maven build
•	API documentations is done by using Swagger 




Code Setup and Execution
------------------------

1.	Checkout project from GIT https://github.com/jasarmcj/retail.git
2.	Open terminal and go to project parent folder /retail
3.	Do maven build. This compile the poject, run the junit test cases, generates converage report and packages the application to war file in target folder. 
	>mvn clean install
	
	If using eclipse, import the project to eclipse and run the /retail/pom.xml file.
	
4.  The code coverage report is available in the target folder. /retail/target/site/jacoco/index.html	
5.	For running the application, execute RetailApplication.java
6.  In-memory database and tables will be created on startup. Also data will be inserted from file /retail/src/resources/data.sql.
5.  Once application started, use below url to make POST request to invoke the api.

http://localhost:8080/api/v1/checkout

7. Use the below url to see the API documentation in integrated SWAGGER.

http://localhost:8080/swagger-ui.html

The request and response JSON details are available in swagger and also mentioned in the document in /retail/doc/RetailApp Document.docx.

JUnit test cases for all scenarios available in RetailerControllerTest.java. It has test cases for employee user, affiliate user, loyal user and normal users.
The application and junit tests uses the test data available in /retail/src/resources/data.sql file.

INSERT INTO USER (USER_ID, USER_NAME, USER_TYPE, USER_REGISTER_DATE) VALUES(1001, 'Jasar', 'EMPLOYEE', '2018-05-01');
INSERT INTO USER (USER_ID, USER_NAME, USER_TYPE, USER_REGISTER_DATE) VALUES(1002, 'Ali', 'AFFILIATE', '2016-01-01');
INSERT INTO USER (USER_ID, USER_NAME, USER_TYPE, USER_REGISTER_DATE) VALUES(1003, 'Rashid', '', '2017-06-01');
INSERT INTO USER (USER_ID, USER_NAME, USER_TYPE, USER_REGISTER_DATE) VALUES(1004, 'Junaid', '', '2015-04-01');
INSERT INTO USER (USER_ID, USER_NAME, USER_TYPE, USER_REGISTER_DATE) VALUES(1005, 'Keith', '', '2018-03-01');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, PRODUCT_PRICE, DISCOUNT_ALLOWED) VALUES(2001, 'Television', 'ELECTRONICS', 20000.00, 1);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, PRODUCT_PRICE, DISCOUNT_ALLOWED) VALUES(2002, 'Shirt', 'LIFESTYLE', 3000.00, 1);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, PRODUCT_PRICE, DISCOUNT_ALLOWED) VALUES(2003, 'Shoe', 'LIFESTYLE', 4500.00, 1);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, PRODUCT_PRICE, DISCOUNT_ALLOWED) VALUES(2004, 'Wheat', 'GROCERY', 500.00, 0);


















