package ksaito.sandBox;

import ksaito.sandBox.test.base62.TestBase62;
import ksaito.sandBox.test.innerClass.TestInnerClass;
import ksaito.sandBox.test.objectConverter.ObjectConverter;
import ksaito.sandBox.test.outerProcess.TestOuterProcess;

/**
 * SandBoxプロジェクトのメインクラス
 */
public class Application {

    /**
     * エントリーポイント
     * @param args
     */
    public static void main(String[] args) {
        testObjectConverter();
    }

    public static void testBase62() {
        new TestBase62().run();
//        new TestBase62().run("1000000000000000001");
    }
    public static void testInnerClass() {
        new TestInnerClass().run();
    }
    public static void testOuterProcess() {
//        new TestOuterProcess().run();
        new TestOuterProcess().run(TestOuterProcess.MODE.NEW);
    }
    public static void testObjectConverter() {
        new ObjectConverter().run();
    }
}
