Readme
This is the explanation of how you should start the application and run it.
I sent you the application in form of zip file, since I was unable to access github and push there. I have only company laptop on vacation with me and sadly it is forbidden to do these sorts of things on personal accounts.
You want to unzip your file and open with editor of your choice. You need to have at least Java 17 on your PC, maven and PostreSQL running. 
Create database using following command:
CREATE DATABASE threedice;

In the resource folder, update credentials in yml file.

Run the app using maven.

For testing, use POST method and point to the localhost:8080/api/bet

I was using Postman, and in the JSON Body add player info, bet amount and outcome prediction.

You can insert player manually into database for testing purposes. Example:

INSERT INTO player(name, balance) VALUES (‘Vladan’ , 9999);

(You can use different name if you don’t like mine :) ).

Also, I was using Lombok, to make it easier with constructor, getters and setters creation. Jakarta for validation purposes.
