## Title: APIs Testing using RestAssured
This project automate "https://github.com/vdespa/introduction-to-postman-course/blob/main/simple-books-api.md" APIs requests using rest assured.

## Description
This projects contains Test package that included:
1) Book Apis class-->

   ** GET books request method: "https://simple-books-api.glitch.me/books"
   this method automates that api returns a list of books. and we validate by status code and type.

   ** GET/BookId request method: "https://simple-books-api.glitch.me/books/bookId"
   this method automates that api retrieves detailed information about a specific and selected book. and we validate all book data           has been retrieved successfully.
 |Parameter|
 | bookId |


2)Create Order Apis class-->

  ** POST order request method: "https://simple-books-api.glitch.me/orders"
  this method automates that api creates an order with request data. and we validate on status and orderId has been passed.
  |Parameters|
  | bookId | customer name |
 
  ** GET created order request method: "https://simple-books-api.glitch.me/orders/orderId"
  this method automates that order created succussfully and we validate on body data that we sent in the previous request has been          retrieved.
  |Parameter|
  | OrderId | 

  ** PATCH order request method: "https://simple-books-api.glitch.me/orders/orderId"
   this method automates that api updates the previous order with a new data. and we validate on status code.
  |Parameter|
  | OrderId | 
  
  ** DELETE order request method: "https://simple-books-api.glitch.me/orders/orderId"
   this method automates that api deleted the previous order successfully. and we validate on status code.
  |Parameter|
  | OrderId | 



## Report
to run report run all tests from testng.xml file first then open allureresult folder in system explorer --> run cmd command"allure serve", it will display allure report in a new broswer.
