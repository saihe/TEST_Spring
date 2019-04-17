package ksaito.test007.utilities;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

/**
 * 共通定数定義クラス
 */
public class ConstsUtil {
    /** 終了コード：正常 */
    public static final int RESULT_CODE_NORMAL = 0;
    /** 終了コード：異常 */
    public static final int RESULT_CODE_ERROR = 1;
    /** ファイル操作エンコード */
    public static final Charset FILE_ENCODE = StandardCharsets.UTF_8;
    /** ファイル出力挙動 */
    public static final StandardOpenOption OPEN_OPTION = StandardOpenOption.CREATE;
    /** 区切り文字：カンマ */
    public static final String SEPARATER_COMMA = ",";

}
