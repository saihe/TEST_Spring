package ksaito.test;

import ksaito.test.Utilities.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {
    @Autowired
    private PropertiesUtil prop;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
