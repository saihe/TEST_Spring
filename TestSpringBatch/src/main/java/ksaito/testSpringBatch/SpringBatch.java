package ksaito.testSpringBatch;

import ksaito.testSpringBatch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringBatch {

    private final String batchId001 = "batch001";
    @Autowired
    private TestService testService;
    @Autowired
    private BatchProperties batchProperties;

//    public SpringBatch() {
//        System.out.println("バッチ起動フラグ一覧");
//        for(String key: batchProperties.getActive().keySet()){
//            System.out.println("key：[" + key + "]、value：[" + batchProperties.getActive().get(key) + "]");
//        }
//    }

    @Scheduled(initialDelayString = "${scheduled.delay.initial}", fixedDelayString = "${scheduled.delay.fixed}")
    public void batch001(){
        System.out.println("起動バッチ：[batch001]");
        System.out.println("有効化フラグ：[" + batchProperties.getActive().get(batchId001) + "]");
        testService.print();
    }
}

