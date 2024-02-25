## Table of Contents
- [Setup](#setup)
- [Techstack](#Techstack)
- [Additional Documentation](#reference-documentation)
- [Guides](#guides)
- [Docker Compose Support](#docker-compose-support)
- [Building and running your application](#Building-and-running-your-application)
- [Deploy your application to the cloud](#deploying-your-application-to-the-cloud)


# Setup

The The application is shipped with two different profiles:
+ dev running on port 8000
+ prod running on port 9000

Dev is set as default profile. Therefor, the application can be launched in two different ways:
+ java -jar solution-0.0.1-SNAPSHOT.jar
+ java -jar -Dspring.profiles.active=prod solution-0.0.1-SNAPSHOT.jar

# Endpoints

The following access points are implemented so far
* POST /create: To create a new user
* Get /all: Return all users stored
* Get /allByGivenName: Return all users with same first name
* Get /byId/{userId}: Return user with a certain ID
* PUT /update: Update an existing user
* DELEte /deleteById/{userId}: Delete a user with a certain ID


# Techstack

* Java 21
* Springboot 3.0.0
* Swagger 3.0.0
* Undertow 3.2.2
* Springdoc 2.3

# Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#data.sql.jdbc)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#features.docker-compose)

# Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

# Docker Compose Support
This project contains a Docker Compose file named `compose.yaml`.

However, no services were found. As of now, the application won't start!

Please make sure to add at least one service in the `compose.yaml` file.

### Building and running your application

When you're ready, start your application by running:
`docker compose up --build`.

Your application will be available at http://localhost:8000.

### Deploying your application to the cloud

First, build your image, e.g.: `docker build -t myapp .`.
If your cloud uses a different CPU architecture than your development
machine (e.g., you are on a Mac M1 and your cloud provider is amd64),
you'll want to build the image for that platform, e.g.:
`docker build --platform=linux/amd64 -t myapp .`.

Then, push it to your registry, e.g. `docker push myregistry.com/myapp`.

Consult Docker's [getting started](https://docs.docker.com/go/get-started-sharing/)
docs for more detail on building and pushing.
