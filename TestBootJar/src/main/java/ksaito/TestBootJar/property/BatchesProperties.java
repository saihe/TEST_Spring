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
public class BatchesProperties {
    private Map<String, SubBatchProperties> batches = new HashMap<String, SubBatchProperties>();
    public SubBatchProperties getBatch(String batchId) {
        return this.batches.get(batchId);
    }
}
