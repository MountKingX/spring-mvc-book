# spring-mvc-book
A Spring Boot coding practice with Spring MVC book

## How to run it
* import project as gradle one with IntelliJ
* run class MvcApplication (`com.book.mvc.MvcApplication.java`) or its main() function, 
* in browser, visit localhost:8080 or localhost:8080/index

## Contents included
* Chapter 1: Configuring a Spring Development Environment
* Chapter 2: Spring MVC Architecture – Architecting Your Web Store
* Chapter 3: Control Your Store with Controllers
* Chapter 4: Working with Spring Tag Libraries
* Chapter 5: Working with View Resolver

## Some specifications
1. In a standard spring-boot2 project, ServletInitializer is not required, here I kept it as spring.io initialize the project with it. 
   I guess it is because that I selected .war as the deployment file.
2. I think `.war` plugin in (at file build.gradle line 5: id 'war') is required, since JSP needs `tomcat` and `tomcat-embed-jasper`, 
   while the default container for spring-boot should be jetty.
3. We use jsp as view resolver so configure it at file /resources/application.properties:
    ```bash
    spring.mvc.view.prefix=/WEB-INF/views/
    spring.mvc.view.suffix=.jsp
    ```
    which is identical to use `@Bean` at a configuration file.
    The location of view does not matter (we do not need to use /WEB-INF). We choose this convention because jsp files of Spring MVC always store in this path traditionally.
4. Checkstyle files location: `/config/checkstyle`. To run checkstyle, go to IntelliJ's right-side menu
   Gradle -> other -> `checkstyleMain`.
5. Make sure we are using the correct `JSTL` lib
6. A more popular in-memory database for spring-boot is H2, here we follow what the mvc book use
7. It is highly recommended to use `Lombok` package, since @Data has a lot of magics such as saving your time for getters and setters
8. `message.properties` has some form labels which is similar to configuration in the book
9. Added the sample for `redirectAttributes.addFlashAttribute`
10. Not successfully to view xml and json Product in Chapter 5

---
last updated on April 14th, 2020
