package ksaito.test.api.controller;

import ksaito.test.Utilities.IOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Test用クラス
 */
@RestController
@RequestMapping("/api/test")
public class TestController extends BaseController{

    /**
     * プロパティ取得確認テスト処理
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<String> index() {
        List<String> returnObject = Arrays.asList(
                prop.getPropertyBean().getTest01()
                , prop.getPropertyBean().getTest02()
                , prop.getPropertyBean().getLog02()
                , prop.getPropertyBean().getLog02()
        );

        IOUtil.print(prop.getPropertyBean().getTest01());
        IOUtil.print(prop.getPropertyBean().getTest02());
        IOUtil.print(prop.getPropertyBean().getLog01());
        IOUtil.print(prop.getPropertyBean().getLog02());

        return returnObject;

    }

}
