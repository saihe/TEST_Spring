package ksaito.testSpringBatch;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@ConfigurationProperties(prefix = "scheduled")
public class BatchProperties {

    private Map<String, String> active = new HashMap<String, String>();

}
