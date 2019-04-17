package ksaito.test006;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * CSVファイルを読み込み指定した文字列を変換するアプリケーション
 */
public class Main {

    /** ファイル操作エンコード */
    private static final Charset FILE_ENCODE = StandardCharsets.UTF_8;
    /** ファイル出力挙動 */
    private static final StandardOpenOption OPEN_OPTION = StandardOpenOption.CREATE;
    /** ワークフォルダパス */
    private static final String WORK_FOLDER = "C:/tmp/work";
    /** 入力ファイル名 */
    private static final String INPUT_NAME = "input.csv";
    /** 出力ファイル名 */
    private static final String OUTPUT_NAME = "output.csv";
    /** 変換前文字列 */
    private static final String BEFORE_STRING = "sashihara";
    /** 変換後文字列 */
    private static final String AFTER_STRING = "sashiko";

    /**
     * エントリーポイント
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 入力ファイルパス取得
            Path inputFilePath = Paths.get(WORK_FOLDER, INPUT_NAME);
            // 出力ファイルパス取得
            Path outputFilePath = Paths.get(WORK_FOLDER, OUTPUT_NAME);
            // 全行取得（UTF-8として読み込み）
            List<String> inputLines = Files.readAllLines(inputFilePath, FILE_ENCODE);
            // 出力用リスト
            List<String> outputLines = new ArrayList<String>();
            // 各行の文字列置き換えを実施
            for(String inputLine: inputLines) {
                // 分割
                String[] tokens = inputLine.split(Pattern.quote(","));
                // 出力用行
                StringBuilder outputLine = new StringBuilder();
                for(String beforeToken: tokens) {
                    String afterToken = beforeToken.replace(BEFORE_STRING, AFTER_STRING);
                    outputLine.append(afterToken);

                }
                outputLines.add(outputLine.toString());

            }
            // 全行出力
            Files.write(outputFilePath, outputLines, FILE_ENCODE, OPEN_OPTION);

        } catch (IOException | UnsupportedOperationException | SecurityException  e) {
            // 例外処理
            e.printStackTrace();

        }

    }

}
