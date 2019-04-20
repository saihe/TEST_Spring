package DTO;

import java.util.List;

import lombok.Data;

/**
 * 起動引数を格納するクラス
 * @author kyohei
 *
 */
@Data
public class ArgumentsDto {

	/** 起動引数のリスト */
	private List<String> argumentsList;

}