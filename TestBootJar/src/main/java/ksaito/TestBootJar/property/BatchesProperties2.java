package ksaito.TestBootJar.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Configuration
@Component
@ConfigurationProperties(prefix = "")
public class BatchesProperties2 {
    private Map<String, SubBatchProperties> batches = new HashMap<String, SubBatchProperties>();
//    public String getInisitalDelay(String batchId) {
//        return this.batches.get(batchId).getInitialDelay();
//    }
//    public String getFixcedDelay(String batchId) {
//        return this.batches.get(batchId).getFixedDelay();
//    }

    @Getter
    @Setter
//    @Configuration
//    @Component
//    @ConfigurationProperties(prefix = "batches")
    public class SubBatchProperties {
        private String initialDelay;
        private String fixedDelay;
    }
}
