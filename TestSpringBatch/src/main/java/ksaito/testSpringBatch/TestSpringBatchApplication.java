package ksaito.testSpringBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBatchApplication.class, args);
    }

}
