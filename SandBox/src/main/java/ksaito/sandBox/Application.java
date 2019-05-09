package ksaito.sandBox;

import ksaito.sandBox.test.base62.TestBase62;
import ksaito.sandBox.test.innerClass.TestInnerClass;
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
//        new TestBase62().run("1000000000000000001");
        new TestOuterProcess().run(TestOuterProcess.MODE.NEW);
    }

}
