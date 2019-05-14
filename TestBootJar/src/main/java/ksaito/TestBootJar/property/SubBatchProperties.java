package ksaito.TestBootJar.property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubBatchProperties {
    private String initialDelayString;
    private String fixedDelayString;
    @Override
    public String toString() {
        return "{" + this.initialDelayString + "," + this.fixedDelayString + "}";
    }
}
