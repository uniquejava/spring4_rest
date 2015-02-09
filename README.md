# Spring 4 demo project
This project will demo the techniques that would be used in our project. This version 1 will be just a general-purpose website, it has front-end and backend, the backend requires login. The documentation is still ongoing.

![login page](doc/images/cms_login.png)

###Todo
1. ~~webservices security~~(done)
2. Asked one question on [stackoverflow](http://stackoverflow.com/questions/28413070/in-spring-mvc-4-1-is-there-any-nonresponsebody-to-return-a-normal-view) (not replied)
3. A simple Android native client consuming RESTful service.
4. A hybrid mobile client consuming RESTful service.

###How to setup
1. Get the code
`git clone https://github.com/uniquejava/spring4_rest.git`

2. Open project in eclipse, the maven plugin should automatically download the required jars.

3. Run script `doc/sql/mysql.sql`
4. Deploy to Tomcat

5. Open in browser: http://localhost:8080/rest/

###Components
1. spring 4.1.4
2. jackson 2.5
1. ~~bootstrap-3.3.2~~
2. jquery-1.11.2

###Features(v1)
1. RESTful CRUD (@RestController in Spring4.x)
3. Slf4j + ~~logback~~ Log4j
4. Error handling

###Environment
Here is the environment I am working on.

1. Ubuntu12.04.5 LTS
2. Eclipse JEE 4.3
3. Tomcat 7.0.57
4. JDK1.6.0_45

However, this project is fully tested on Win7 + WAS8.5

