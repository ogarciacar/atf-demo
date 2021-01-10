# atf-demo
Automated Test Framework Demo

### Environment

For the Automated Test Framework (ATF) to work it is required to have the following
testing environment:

* Java 11 or later
  ```bash
  $ java --version
  ```
* Maven 3.6 or later (Optional. A maven wrapper has been distributed with the demo)
  ```bash
  # using the wrapper command
  $ ./mvnw --version
  
  # or using installed maven
  $ mvn --version
  ```
* Docker 20 or later
  ```bash
  $ docker --version
  ```
* Text Editor with Java support (IntelliJ Idea, Eclipse, VS Code)
* Terminal windows

### Project Package Structure
The project is a standard SpringBoot application with testing support.
It was generated with the [Spring Initializer](https://start.spring.io/)
and provisioned with test dependencies to support BDD and REST API testing.
```bash
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── gig
    │   │           └── atfdemo
    │   └── resources
    │       └── application.properties
    └── test
        ├── java
        │   └── com
        │       └── gig
        │           └── atfdemo
        └── resources


```
* The *test code* is located in `src/test/java` directory.
* The *feature* files are located in `src/test/resources` directory.
* The directory `src/mainjava` will not contain any code since it is reserved for business facing code.

### Dependencies

The ATF's dependencies are managed with Maven. They are declared in the `pom.xml` file.
Dependencies are installed by executing in the project root directory:
```bash
# using the maven wrapper
$ ./mvnw dependency:resolve

# alternatively with maven installed
$ mvn dependency:resolve
```
The key test-related dependencies are:
* [Cucumber](https://cucumber.io/) for BDD testing enablement and Gherkin syntax support.
* [REST Assured](https://rest-assured.io/) for testing REST APIs.