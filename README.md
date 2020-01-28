# Back end Challenge Solution

### Interview hands-on answer for IQVIA.com 
IDE: STS(version 3.9.11.RELEASE)

* [Java code doc](./doc/index.html)


### Unit test command
mvn clean test

### Test and Build command
mvn package

### Restful Api Testing 
1. create a printing job

   Method: Post
   
   Url   : http://localhost:8080/schedules/create
   
   Header: Content-Type: "application/json" 
   
2. query a printing job by id

   Method: Get
   
   Url   : http://localhost:8080/schedules/get/{id}
  
  