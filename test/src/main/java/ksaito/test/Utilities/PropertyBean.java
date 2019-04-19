package ksaito.test.Utilities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Properties;

/**
 * 外部定義した設定情報を格納するクラス
 */
@Data
@Configuration
@ConfigurationProperties
//@PropertySources({
//        @PropertySource("file:C:/work/test/TEST_Spring/test/src/lib/application.yml")
////        @PropertySource("file:${lib.property.name.application}")
////    , @PropertySource("file:${lib.property.name.log}")
//})
public class PropertyBean {
    /** test.01 */
    @Value("test.01")
    private String test01;
    /** test.02 */
    @Value("test.02")
    private String test02;
    /** log.01 */
    @Value("log.01")
    private String log01;
    /** log.01 */
    @Value("log.02")
    private String log02;
}
