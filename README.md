# NotificationDemo
## Synopsis
Generic Notification System
This project demonstrate sample generic library for notification.

Following capabilities are supported:

1. Accept messages including from, to and subject
2. Ability to notify on multiple channels (email, slack)
3. Deliver messages in correct order


## Technologies
Spring Boot 
Jackson
spring-email

## Installation
Run mvn spring-boot:run to start the server 


## API Reference
API 1: Notify to a Channel

URL: http://localhost:8080/api/v1/notification/notify/EMAIL

This sends given message to a specified channel like slack or email. Where the channelType is SLACK or EMAIL.

e.g: http://localhost:8080/api/v1/notification/notify/EMAIL
with body as:

## EMAIL
{  
   "text": "Body of the message",  
   "from": "from@gmail.com",  
   "subject": "Notification Service Test Subject",  
   "to": "to@gmail.com"  
 }
 
 e.g: http://localhost:8080/api/v1/notification/notify/SLACK

 ## SLACK
 {
 "text":"hello","username":"new slack"
 }
 
 
API 2: Notify All

URL: http://localhost:8080/api/v1/notification/notifyAll

This sends given message to all configured channels like slack and email.

e.g: http://localhost:8080/api/v1.0/notifier/notifyAll with body as:


{  
   "text": "Body of the message",  
   "from": "from@gmail.com",  
   "subject": "Notification Service Test Subject",  
   "to": "to@gmail.com"  
 }
 
 
 
 # Note :
 
 add username and password
spring.mail.username=
spring.mail.password=
in application.properties file and also enable less secure apps in gmail->ManageAccount->Security->Enable less secure apps and run the application for Email

 
 SignUp in slack 
 add slack.channel.api in application.properties file by creating a new URL in slack website . Then run the appliction for slack 
