package ksaito.TestBootJar.service;

import ksaito.TestBootJar.property.*;
import ksaito.testLibrary.Library01;
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
        Library01.print("==============メッセージ全部==============");
        messagesBean.getMessages().keySet().forEach(key -> Library01.print(key + "：" + messagesBean.getMessages().get(key)));
        Library01.print("==========================================");
        Library01.print(messageId + "：" + messagesBean.getMessage(messageId));
    }
    public void printBatch (String batchId) {
        Library01.print("==============バッチ情報全部==============");
        batchesProperties.getBatches().keySet().forEach(key ->  Library01.print(key + "：" + batchesProperties.getBatches().get(key)));
        Library01.print("==========================================");
        Library01.print(batchId + "：" + batchesProperties.getBatch(batchId));
    }
}
