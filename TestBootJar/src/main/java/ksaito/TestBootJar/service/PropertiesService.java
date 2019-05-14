package ksaito.TestBootJar.service;

import ksaito.TestBootJar.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class PropertiesService {
    @Autowired
    private Properties prop;
    @Autowired
    private MessagesProperties messagesBean;
    @Autowired
    private BatchesProperties batchesProperties;

    public void printMessage (String messageId) {
        System.out.println("==============メッセージ全部==============");
        for(String key: messagesBean.getMessages().keySet()) {
            System.out.println(key + "：" + messagesBean.getMessages().get(key));
        }
        System.out.println("==========================================");
        System.out.println(messageId + "：" + messagesBean.getMessage(messageId));
    }
    public void printBatch (String batchId) {
        System.out.println("==============バッチ情報全部==============");
        for(String key: batchesProperties.getBatches().keySet()) {
            System.out.println(key + "：" + batchesProperties.getBatches().get(key));
        }
        System.out.println("==========================================");
        System.out.println(batchId + "：" + batchesProperties.getBatch(batchId));
    }
}
