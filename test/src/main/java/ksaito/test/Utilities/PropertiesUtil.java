package ksaito.test.Utilities;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * 外部定義したプロパティに関するクラス
 */
@Service
@Getter
public class PropertiesUtil extends Properties {
    @Autowired
    private PropertyBean propertyBean;

//    public  PropertiesUtil () throws  IOException{
//        Properties properties = new Properties();
//        this.propertyBean = new PropertyBean();
//        try {
//            String propertyDir = properties.getProperty("lib.dir");
//            String propertyFileName = properties.getProperty("lib.property.name.application");
//            Path propertyFilePath = Paths.get(propertyDir, propertyFileName);
//        } catch (NullPointerException e) {
//            throw e;
//        }
//    }
}
