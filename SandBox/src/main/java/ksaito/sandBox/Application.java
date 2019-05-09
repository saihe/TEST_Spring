package ksaito.sandBox;

import ksaito.sandBox.test.base62.TestBase62;
import ksaito.sandBox.test.innerClass.TestInnerClass;

/**
 * SandBoxプロジェクトのメインクラス
 */
public class Application {

    /**
     * エントリーポイント
     * @param args
     */
    public static void main(String[] args) {
        new TestBase62().run("1000000000000000001");
    }

}
