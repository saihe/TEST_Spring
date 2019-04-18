package ksaito.test007;

import ksaito.test007.utilities.PropertyUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.regex.Pattern;
import ksaito.test007.utilities.ConstsUtil;


/**
 * CSVファイルを読み込み指定した文字列を変換するクラス
 */
@Slf4j
public class ReplaceStringInCSV {

    /**
     * 処理開始
     * @return
     */
    public int processStart() {
        log.info("処理開始");
        int resultCode = ConstsUtil.RESULT_CODE_NORMAL;
        try {
            // 作業フォルダ
            String workFolder = PropertyUtil.getProperty(PropertyUtil.PROPERTY_WORK_FOLDER_PATH);
            // 入力ファイル名
            String inputFileName = PropertyUtil.getProperty(PropertyUtil.PROPERTY_INPUT_FILE_NAME);
            // 出力ファイル名
            String outputFileName = PropertyUtil.getProperty(PropertyUtil.PROPERTY_OUTPUT_FILE_NAME);
            // 変換テーブル
            List<PropertyUtil.ReplaceTable> replaceTableList = PropertyUtil.getReplaceTable();

            // 入力ファイルパス取得
            Path inputFilePath = Paths.get(workFolder, inputFileName);
            // 出力ファイルパス取得
            Path outputFilePath = Paths.get(workFolder, outputFileName);
            // 全行取得（UTF-8として読み込み）
            List<String> inputLines = Files.readAllLines(inputFilePath, ConstsUtil.FILE_ENCODE);
            // 出力用リスト
            List<String> outputLines = new ArrayList<String>();
            // 各行の文字列置き換えを実施
            for(String inputLine: inputLines) {
                // 分割
                String[] tokens = inputLine.split(Pattern.quote(ConstsUtil.SEPARATER_COMMA));
                // 出力用行
                StringBuilder outputLine = new StringBuilder();
                for(int indexCounter = 0; indexCounter < tokens.length; indexCounter++) {
                    String beforeToken = tokens[indexCounter];
                    String afterToken = replaceString(beforeToken, replaceTableList);
                    if (indexCounter > 0) {
                        outputLine.append(ConstsUtil.SEPARATER_COMMA);

                    }

                    outputLine.append(afterToken);

                }
                outputLines.add(outputLine.toString());

            }
            // 全行出力
            Files.write(outputFilePath, outputLines, ConstsUtil.FILE_ENCODE, ConstsUtil.OPEN_OPTION);

        } catch (
                NullPointerException
                        | MissingResourceException
                        | ClassCastException
                        | IOException
                        | UnsupportedOperationException
                        | SecurityException  e
        ) {
            // 例外処理
            resultCode = ConstsUtil.RESULT_CODE_ERROR;
            log.error("例外発生", e);

        }

        log.info("正常終了");
        return  resultCode;

    }

    /**
     * 文字列置き換え
     */
    private String replaceString(
            String targetString
            , List<PropertyUtil.ReplaceTable> replaceTableList
    ) {
        String resultString = targetString;
        for(PropertyUtil.ReplaceTable replaceTable: replaceTableList) {
            resultString = resultString.replace(
                    replaceTable.getBeforeString()
                    , replaceTable.getAfterString()
            );
        }

        return resultString;

    }
}
