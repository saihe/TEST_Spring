package ksaito.TestBootJar.service;

import ksaito.TestBootJar.property.BatchesProperties;
import ksaito.TestBootJar.property.BatchesProperties2;
import ksaito.TestBootJar.property.MessagesProperties;
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
    @Autowired
    private BatchesProperties2 batchesProperties2;

    public void printMessage (String messageId) {
        System.out.println("==============メッセージ全部==============");
        for(String key: messagesBean.getMessages().keySet()) {
            System.out.println(key + "：" + messagesBean.getMessages().get(key));
        }
        System.out.println("==========================================");
        System.out.println(messageId + "：" + messagesBean.getMessage(messageId));
    }
    public void printBatch (String batchId) {
        System.out.println("==============メッセージ全部==============");
        for(String key: batchesProperties.getBatches().keySet()) {
            System.out.println(key + "：" + batchesProperties.getBatches().get(key));
        }
        System.out.println("==========================================");
        System.out.println(batchId + "：" + batchesProperties.getBatch(batchId));
    }
    public void printBatch2 (String batchId) {
        System.out.println("==============バッチ情報全部==============");
        for(String key: batchesProperties2.getBatches().keySet()) {
            System.out.println(key + "：" + batchesProperties2.getBatches().get(batchId).getInitialDelay());
            System.out.println(key + "：" + batchesProperties2.getBatches().get(batchId).getFixedDelay());
        }
        System.out.println("==========================================");
        System.out.println(batchId + "：" + batchesProperties2.getBatches().get(batchId));
    }
}
