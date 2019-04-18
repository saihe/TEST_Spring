package ksaito;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.nio.channels.ClosedChannelException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Slf4j
public class Ryu001 {
    private final String path = "C:/work/shinsei/test/TEST_Spring/test008/src/lib/test.xml";

    public void ryu() {
        try {
            log.info("処理開始");
            Properties prop = new Properties();

//            prop.loadFromXML(Files.newInputStream(Paths.get(path)));
            InputStream is = Files.newInputStream(Paths.get(path));
            log.debug(String.valueOf(is.available()));
            prop.loadFromXML(is);
            is.close();
            log.debug(String.valueOf(is.available())); //ここでエラーになる


            log.debug(prop.getProperty("account"));
            log.debug(prop.getProperty("user"));
            log.debug(prop.getProperty("pass"));
            log.debug(prop.getProperty("csv"));

        } catch(ClosedChannelException e) {
            log.error("ストリームが既に閉じている。", e);
        } catch (Exception e) {
            log.error("予期しないエラー", e);
        }
        log.info("処理終了");
    }
}