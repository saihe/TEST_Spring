package test009;

import java.util.Arrays;

import DTO.ArgumentsDto;
import Utilieits.ConstsUtil;
import Utilieits.RyuUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 竜の勉強用クラス
 * @author kyohei
 *
 */
@Slf4j
public class Ryu001 {

	/**
	 * テストを行う処理
	 * @return 終了コード
	 * 成功：0
	 * 失敗：1
	 */
	public int ryu(String[] argumentsArray) {
		int resultCode = ConstsUtil.RESULT_CODE_NORMAL;
		log.info("処理開始");
		try {
			ArgumentsDto arguemtnsDto = new ArgumentsDto();
			arguemtnsDto.setArgumentsList(Arrays.asList(argumentsArray));
			log.debug(
				RyuUtil.createMessage(
					"引数[0]：{0}"
					, new Object[] {
						arguemtnsDto.getArgumentsList().get(0)
					}
				)
			);
		} catch (NullPointerException e) {
			resultCode = ConstsUtil.RESULT_CODE_ERROR;
			log.error("ヌルポ", e);
		} catch (Exception e) {
			resultCode = ConstsUtil.RESULT_CODE_ERROR;
			log.error("異常終了", e);
		}
		log.info("処理終了");
		return resultCode;
	}

}
