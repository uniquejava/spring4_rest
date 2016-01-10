# Spring 4 learning project
This project will demo the techniques that would be used in our project. This version 1 will be just a general-purpose website (I call it `bare version`), it has a front-end and a back-end, the backend requires login. The documentation is in another project, it's just my personal learning notes.

![login page](doc/images/cms_login.png)

###Todo
1. ~~Web services security~~(done)
2. ~~Asked one question on [stackoverflow](http://stackoverflow.com/questions/28413070/in-spring-mvc-4-1-is-there-any-nonresponsebody-to-return-a-normal-view)~~ (replied)
3. ~~RESTful CRUD (@RestController in Spring4.x)~~(done)
4. ~~Slf4j + Log4j~~(done)
5. Error handling(ongoing)
6. what's the difference between ctx-annotation-config and mvc-annotation-driven(reading)
7. i18n: MessageSourceAware
8. A simple Android native client consuming RESTful service.(reading a book)
9. A hybrid mobile client consuming RESTful service(learning).

###How to setup
1. Get the code
`git clone https://github.com/uniquejava/spring4_rest.git`

2. Open project in eclipse directly, the maven plugin(built-in with Eclipse 4.x) should automatically download the required jars.
>Also you can open this project in IDEA but ensure you right click on the pom.xml and mark this project as a Maven project.

3. For eclipse users, after you imported the project, there are 2 settings:
 * Right click on Project > Properties > `Project Facets`, check the "Java 1.6" and "Dynamic Web Module 3.0".
 * Then click on `Web Project Settings`, change the context root to `rest` or any context root u like.

4. Open `cms.properties`, change your database password there if needed.

5. Run script `doc/sql/*.sql`, click [here](setup_database.md) for more details on how to setup database (MySQL,DB2,HSQLDB).

6. Deploy to Tomcat

7. Open in browser: http://localhost:8080/rest/

###Components
1. Spring 4.2.4
2. jackson 2.5
1. ~~bootstrap-3.3.2~~
2. jquery-1.11.2

###Roadmap
Bare version will be proactive and will demo/use the latest techniques if i am happy.

General version would be done if i have time.

Corporation version is for internal use and close source.

`Bare`:
* i18n
* cluster
* excel, odf, pdf
* jpa
* cache

`General`
* bootstrap3.3.2
* kindeditor

`Corporation`:
* [V18](https://github.com/ibmmxlabs/v18) integeration

###Environment
Here is the environment I am working on.

1. Ubuntu12.04.5 LTS (Mac OSX 10.11)
2. Eclipse JEE 4.3 (Eclipse JEE MARS.1)
3. Tomcat 7.0.57 (Tomcat 8.x)
4. JDK1.6.0\_45 (JDK1.7.0\_80)
5. Maven3.2.5 (Maven3.3.3)

However, this project is fully tested on Win7 + WAS8.5

