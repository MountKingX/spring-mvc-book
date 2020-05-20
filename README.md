# spring-mvc-book
A Spring Boot coding practice with Spring MVC book (gradle, JSP)

## How to run it
* import project as gradle one with IntelliJ
* run class MvcApplication (`com.book.mvc.MvcApplication.java`) or its main() function, 
* in Browser, visit localhost:8080 or localhost:8080/index (not /webstore as the root url)

## Contents included
* Chapter 1: Configuring a Spring Development Environment
* Chapter 2: Spring MVC Architecture – Architecting Your Web Store
* Chapter 3: Control Your Store with Controllers
* Chapter 4: Working with Spring Tag Libraries
* Chapter 5: Working with View Resolver
* Chapter 6: Internalize Your Store with Interceptor
* Chapter 7: Incorporating Spring Security
* Chapter 8: Validate Your Products with a Validator
* Chapter 9: Give REST to Your Application with Ajax
* Chapter 12: Testing Your Application

## Some specifications
1. In a standard spring-boot2 project, ServletInitializer is not required, here I kept it as spring.io initialize the project with it. 
   I guess it is because that I selected .war as the deployment file.
2. It appears that `.war` plugin in (at file build.gradle line 5: id 'war') is required, since JSP needs `tomcat` and `tomcat-embed-jasper`, 
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
10. Right now, this project is not successfully to view xml and json Product in Chapter 5
11. We might need to change `log4j.appender.file.File=` to your local directory to store the log. For example, I am using Ubuntu so I set it as`/home/kangmin/log4j/webstore-performance.log`:
    ```bash
    ...
    # Direct log messages to a log file
    log4j.appender.file=org.apache.log4j.RollingFileAppender
    log4j.appender.file.File=/home/kangmin/log4j/webstore-performance.log
    ...
    ```
12. ProcessingTimeLogInterceptor generates more logs than the mvc-book, as a result of using webjars: we store the css/js within this webapp
13. Added `redirected message` for `PromoCodeInterceptor` when redirecting to products page
14. We can use Session and Interceptors to handle Authentication & Authorization, the code is implemented in branch MVC-Session with user/password pairs: ('normal', 123), ('admin', 123)
15. Simple Configuration of Spring Security: using static inMemoryAuthentication() instead of DB users: ('john', ''pa55word'), ('admin', 'root123');
16. As the requirement of Spring-5, a Bean of `BCryptPasswordEncoder` is configured;
17. In jsp, we can take advantage of security tag and show things when necessary: `<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>`
18. Qualifier added for `ProductValidator` 's javax.validation.Validator beanValidator attribute, which is for `LocalValidatorFactoryBean` at WebMvcConfig.java;
19. Ajax calls from Angular.js were not achieved
20. In Testing Your Application chapter's code, find a bug for `cartItem.setProduct(iphone);`
21. For Integration Testing's @ContextConfiguration, use `(classes = MvcApplication.class)` instead of `WebMvcConfig`
22. For MVC controller test, we will use `MockMvcBuilders.standaloneSetup(pc)` instead of `MockMvcBuilders.webAppContextSetup(this.wac)`

* Book spring mvc beginner's guide github: https://github.com/PacktPublishing/Spring-MVC-Beginners-Guide-Second-Edition

---
last updated on May 20th, 2020
