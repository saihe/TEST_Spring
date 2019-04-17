package ksaito.test007;

import lombok.extern.slf4j.Slf4j;

/**
 * CSVファイルを読み込み指定した文字列を変換するアプリケーション
 */
public class Main {

    /**
     * エントリーポイント
     * @param args
     */
    public static void main(String[] args) {
        // 処理
        ReplaceStringInCSV replaceStringInCSV = new ReplaceStringInCSV();
        System.exit(replaceStringInCSV.processStart());
    }

}
