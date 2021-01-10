package com.gig.atfdemo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@CucumberContextConfiguration
public class SpringIntegrationTests {

    @TestConfiguration
    @ComponentScan("com.gig.atfdemo")
    public static  class Configuration {

    }
}
