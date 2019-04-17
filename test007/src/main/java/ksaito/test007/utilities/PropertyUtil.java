package ksaito.test007.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * プロパティ操作
 */
public class PropertyUtil {

    /** リソースバンドル */
    private static ResourceBundle resource = ResourceBundle.getBundle("application");
    /** プロパティ：ワークフォルダパス */
    public static final String PROPERTY_WORK_FOLDER_PATH = "path.folder.work";
    /** プロパティ：入力ファイル名 */
    public static final String PROPERTY_INPUT_FILE_NAME = "name.file.input";
    /** プロパティ：出力ファイル名 */
    public static final String PROPERTY_OUTPUT_FILE_NAME = "name.file.output";
    /** プロパティ：変換テーブル */
    public static final String PROPERTY_REPLACE_TAME = "table.replace";

    /** 配列ではないプロパティ取得 */
    public static String getProperty(String key)
            throws NullPointerException
            , MissingResourceException
            , ClassCastException
    {
        return resource.getString(key);

    }

    /**
     * 変換テーブル取得
     * @return 変換テーブル
     */
    public static List<ReplaceTable> getReplaceTable ()
            throws NullPointerException
            , MissingResourceException
            , ClassCastException
    {
        List<ReplaceTable> replaceTableList = new ArrayList<ReplaceTable>();
        // プロパティから取得した変換テーブルを格納（beforeString：afterString,...）
        for (String paramater:resource.getStringArray(PROPERTY_REPLACE_TAME)) {
            String[] property = paramater.split(Pattern.quote(":"));
            ReplaceTable replaceTable = new ReplaceTable(property[0], property[1]);
            replaceTableList.add(replaceTable);

        }

        return replaceTableList;

    }

    /**
     * 変換テーブル
     */
    @Data
    @AllArgsConstructor
    public static class ReplaceTable {
        /** 変換前文字列 */
        private String beforeString;
        /** 変換後文字列 */
        private String afterString;

    }

}
