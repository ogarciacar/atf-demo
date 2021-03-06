package com.gig.atfdemo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@CucumberContextConfiguration
public class SpringIntegrationTests {

    @TestConfiguration
    @PropertySource(name = "kafkaProperties", value = "application.properties")
    @ComponentScan("com.gig.atfdemo")
    public static  class Configuration { }
}
