# atf-demo
Automated Test Framework Demo

### Environment

For the Automated Test Framework (ATF) to work it is required to have the following
testing environment:

* Java 11 or later
  ```bash
  $ java --version
  ```
* Maven 3.6 or later (Optional)
  * A maven wrapper has been distributed with the demo.
  * All tests can be run in a docker container.
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
# using maven in a docker container
$ docker run -it --rm -v "$PWD":/usr/src/mymaven \
    -v "$HOME/.m2":/root/.m2 \
    -w /usr/src/mymaven maven mvn dependency:resolve
    
# using the maven wrapper
$ ./mvnw dependency:resolve

# alternatively with maven installed
$ mvn dependency:resolve
```
The key test-related dependencies are:
* [Cucumber](https://cucumber.io/) for BDD testing enablement and Gherkin syntax support.
* [REST Assured](https://rest-assured.io/) for testing REST APIs.
* [Spring for Apache Kafka](https://spring.io/projects/spring-kafka) for Kafka interaction.

### Test Context Setup

In order to run test scenarios related to the stream processing, it will be required
to recreate the following context:
```bash
# network for testing
$ docker network create app-tier --driver bridge

# zookeper server
$ docker run -d --name zookeeper-server --network app-tier -e ALLOW_ANONYMOUS_LOGIN=yes -p 2181:2181 bitnami/zookeeper:latest

# kafka server
$ docker run -d --name kafka-server --network app-tier -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 -p 9092:9092 bitnami/kafka:latest

# create the cars topic
$ docker run -it --rm --network app-tier -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 bitnami/kafka:latest kafka-topics.sh --bootstrap-server kafka-server:9092 --create --topic cars
```

### Executing the tests

Execute the following command to run the tests:
```bash
# all tests
$ docker run -it --rm --network app-tier -v "$PWD":/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -w /usr/src/mymaven maven mvn clean test
```

### Stream Pipeline Monitor

In order to watch in realtime all messages sent to Kafka execute this command:
```bash
# kafka topic watcher
$ docker run -it --rm --network app-tier -e KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper-server:2181 \
    bitnami/kafka:latest kafka-console-consumer.sh  \
    --bootstrap-server kafka-server:9092 \
    --topic cars
```