Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://courses.rahulshettyacademy.com/" Site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And Close browsers

Examples:
|username				|password	|
|zhkushtarbek@gmail.com	|Hello1234	| 
|test99@gmail.com		|123456		|
|test123@gmail.com		|1234489	|
