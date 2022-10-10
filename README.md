# Trello APIs

I tried to build apis for Trello.com

## Getting Started

Clone the project and run localhost:8080/swagger-ui/index.html. You will see bunch of api endpoints. To get started working with api, firstly register and take authoritaion token. And start working with apis;

### Prerequisites

Before getting started, You should customized datasource properties. I used postgresql but you can use any database of your choice.
```
spring.datasource.url=jdbc:<database_name>://<host_name>:<port>/<database>
spring.datasource.driverClassName=<driver_name>
spring.datasource.username=<datasource_username>
spring.datasource.password=<password>
```

If you want to keep using telegram bot to send errors directly to your telegram account add token to getToken method of telegram bot.
You can get telegram bot token from botFather on telegram. After that whoever press start button to bot gets error messages on their telegram account.



## Built With

* [Spring](http://www.docs.spring.io/1.0.2/docs/) - The java framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Postgresql](https://org.postgresql.com) - Used to save datasources
* etc
