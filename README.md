Bank Transaction Backend built in Java Spring
    Test for Java 17 version
    Include for the moment : Jpa, Web, Lombok annotation and H2 database, 
    The goal is to built endpoints to serve frontend application in Angular

Day 01:
18:45
I'll start to work with statements of problem:
An API to be used for opening a new “current account” of already existing customers.
Requirements
    • The API will expose an endpoint which accepts the user information (customerID,initialCredit).
    • Once the endpoint is called, a new account will be opened connected to the user whose ID is customerID.
    • Also, if initialCredit is not 0, a transaction will be sent to the new account.
    • Another Endpoint will output the user information showing 
        Name, Surname, balance, and transactions of the accounts.
Bonuses
• Accounts and Transactions are different services.




