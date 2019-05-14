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
public class MessagesProperties {
    private Map<String, String> messages;
    public String getMessage(String messageId) {
        return this.messages.get(messageId);
    }
}
