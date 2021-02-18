Please run the below 2 Commands to execute this Project

mvn clean install <br>
mvn jetty:run

For Testing:

POST http://localhost:8080/rest/address/parser<br>
{
    "address": "Calle 39 No 1540"
}

