package ksaito;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Ryu002 implements Ryu {
    public void ryu() {

            LoadXml conf = new LoadXml();
            Properties prop = conf.getPropertyList();

            String confAccount = prop.getProperty("account");
            String confUser     = prop.getProperty("user");
            String confPass     = prop.getProperty("pass");
            String confCsv      = prop.getProperty("csv");

    }

// =========================================================================

    public class LoadXml {

        public static final String path ="C:/Users/lises8/Documents/eclipse/2019.03_eclipse/workspace/test.xml";

        public  Properties getPropertyList() {

            Properties prop = new Properties();

            try {
                prop.loadFromXML(Files.newInputStream(Paths.get(path)));

                String propAccount = prop.getProperty("account");
                String propUser      = prop.getProperty("user");
                String propPass      = prop.getProperty("pass");
                String propCsv        = prop.getProperty("csv");
                boolean isKeyBlank = false;


                if (StringUtils.isBlank(propAccount)){
                    isKeyBlank = true;
                    System.out.println(propAccount);
                }
                System.out.println(isKeyBlank);



                if (StringUtils.isBlank(propUser)){
                    isKeyBlank = true;
                    System.out.println(propUser);
                }
                System.out.println(isKeyBlank);


                if (StringUtils.isBlank(propPass)){
                    isKeyBlank = true;
                    System.out.println(propPass);
                }
                System.out.println(isKeyBlank);


                if (StringUtils.isBlank(propCsv)){
                    isKeyBlank = true;
                    System.out.println(propCsv);
                }
                System.out.println(isKeyBlank);


                if(isKeyBlank == true){
                    System.out.println(prop);
                    System.exit(0);
                }
                System.out.println("処理通過");

            }
            catch (IOException ex) {
                System.out.println(prop);
                ex.printStackTrace();
            }
            return prop;
        }
    }
}
