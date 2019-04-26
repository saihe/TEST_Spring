package ksaito.sandBox.ryu.after;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * りゅうからもらったクラス
 */
public class Ryu01 extends ksaito.sandBox.ryu.before.Ryu01 {
    /**
     * 竜からもらったやつの修正版
     *
     * @throws Exception
     */
    public static void ryu01() throws Exception {
        File file = Paths.get("C:/Users/lises8/Desktop/SumpleTextName.txt").toFile();
        is = Files.newInputStream(Paths.get("C:/Users/lises8/Desktop/SumpleTextName.txt"));

//        Crud crud = new Crud();
//
//        crud.putObject(bucketName, objectKey, objectSize, is);
    }

}
