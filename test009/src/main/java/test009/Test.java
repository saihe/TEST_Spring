package test009;

import Utilieits.RyuUtil;

/**
 * メインクラス
 */
public class Test {

	/**
	 * エントリーポイント
	 * @param args
	 */
	public static void main(String[] args) {
		Ryu001 ryu001 = new Ryu001();

		RyuUtil.exit(ryu001.ryu(args));
	}

}
