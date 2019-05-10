package testJava11;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Hello World.");
        System.out.println("Hello World!");
    }
}
