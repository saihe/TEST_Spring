package ksaito.sandBox.ryu.before;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * りゅうからもらったクラス
 */
public class Ryu01 {
    public static String bucketName = "clhjda-data";
    public static String objectKey = "TestObjectKey";
    public static int objectSize = 13;
    public static InputStream is;

    /**
     * 竜からもらったやつ
     *
     * @throws Exception
     */
    public static void ryu01() throws Exception {
        System.out.println("hello world");


        File file =
                new File(
                        "C:\\Users\\lises8\\Desktop\\SumpleTextName.txt");

        InputStream inputStream = new FileInputStream(file);
//
//        Crud crud = new Crud();
//
//        crud.putObject(bucketName, objectKey, objectSize, is);
    }

}
