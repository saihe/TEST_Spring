package Utilieits;

import java.text.MessageFormat;

/**
 * なんでもクラス
 * @author kyohei
 *
 */
public class RyuUtil {

	/**
	 * アプリケーションを終了し、終了コードを返却する処理
	 * @param resultCode
	 */
	public static void exit(int resultCode) {
		System.exit(resultCode);
	}

	/**
	 * メッセージを作成する処理
	 * @param message
	 * @param argumentsArray
	 * @return
	 */
	public static String createMessage(String message, Object[] argumentsArray) {
		String resultString = "";
		resultString = MessageFormat.format(message, argumentsArray);

		return resultString;

	}
}
