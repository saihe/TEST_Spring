package ksaito.TestBootJar.job;

import ksaito.TestBootJar.service.PropertiesService;
import ksaito.testLibrary.Library01;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.MessageFormat;

@Configuration
@Slf4j
public class Job001 {
    @Autowired
    private PropertiesService propertiesService;

    @Scheduled(fixedDelayString = "1000")
    public void b000() {
        try {
            log.info("{0}：[{1}]", new Object[]{"実行", "B001"});
            log.info("{}：[{}]", new Object[]{"実行", "B001"});
            log.info(MessageFormat.format("{0}：[{1}]", new Object[]{"実行", "B001"}));
            Library01.print(System.getProperty("java.class.path"));
            propertiesService.printMessage("message.001");
            propertiesService.printBatch("b001");
            propertiesService.printBatch2("b001");
            log.debug("Hello world.");
            System.exit(0);
        } catch (Exception e) {
            log.error("エラー", e);
            System.exit(9);
        }
    }
}
