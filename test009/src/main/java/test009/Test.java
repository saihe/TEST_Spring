package test009;

/**
 * メインクラス
 */
public class Test {

	/**
	 * エントリーポイント
	 * @param args
	 */
	public static void main(String[] args) {
		int resultCode = 0;
		try {
			System.out.println("args[0]：" + args[0]);
		} catch (Exception e) {
			resultCode = 9;
			System.out.println("異常終了");
		}
		System.exit(resultCode);
	}

}