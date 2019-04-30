
# User Management Application
Application Frameworks Implementation:
 - [ ] Multiple Database Implementation
	 - [x] H2 DB : In memory DB
	 - [ ] Add MYSQL 
	 - [ ] Add MongoDB 
	 - [x] Redis Caching using Spring Data  
 - [ ] Database Interactions
	 - [x] JPA - Hibernate
	 - [ ] Spring JDBC 
	 - [ ] iBatis 	 
	 - [ ] stored procedures
 - [ ] RestController
	 - [x] CRUD - User
	 - [ ] CRUD - Address 
	 - [ ] CRUD - Phone
	 - [ ] Audit Logging
	 - [ ] Validations 
	 - [ ] CORS Support 
	 - [ ] Cache Rest Repsonse using Redis
 - [x] Swagger UI
 - [ ] Exception Management
	 - [ ] Handle Exception Controller using @AdviceController
 - [ ] AOP Logs 
	 - [x] Request Attributes
	 - [ ] Response Payload Logs
	 - [x]  All Exception Logs
 - [ ] Transaction Management 
 - [ ] TDD
	 - [ ] Junit Test Cases 
	 - [ ] Code Coverage Code
	 - [ ] Quality Integration Test Suite 
 - [ ] Spring MVC 
	 - [ ] JSP
	 - [ ] Thymeleaf 
 - [ ] Spring Security 


 **References:**
 - Swagger UI: https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 - Readme.me Editor: https://stackedit.io/app#
 - https://www.baeldung.com/spring-data-rest-intro
 - https://www.baeldung.com/spring-data-rest-relationships
 - https://docs.spring.io/spring-data/rest/docs/current/reference/html/#_the_hal_browser
	
JPA and Transactions :
- https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
- https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
	
Application URLs:
- http://localhost:8080/usermanagement/
- http://localhost:8080/usermanagement/h2-console
- http://localhost:8080/usermanagement/AddressRepository
- http://localhost:8080/usermanagement/swagger-ui.html

	
Changes History
- 24-March-2019
- Added Address and Phone Entity
- Added Spring Data Rest Repository 
- Added OneToMany Relationship for User, Address and Phone
- Updated User Response Entity
30-Apr-2019
- Integrated Spring Redis Integration
	
	