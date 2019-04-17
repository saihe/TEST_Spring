package ksaito.test003.app.api001;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fujitsu.cris.app.HLFISystemException;
import com.fujitsu.cris.common.LoggerUtil;
import com.fujitsu.cris.config.PropertyBean;
import com.fujitsu.cris.domain.service.hlfip0001.Hlfip0001Service;
import com.fujitsu.cris.domain.service.hlfip0002.Hlfip0002Service;
import com.fujitsu.cris.domain.service.hlfip0003.Hlfip0003Service;
import com.fujitsu.cris.domain.service.hlfip0009.Hlfip0009Service;

@Controller
public class Api001Controller {
    /** ロガー */
    private static final Logger logger = LoggerFactory.getLogger(HLFIS0011Controller.class);
    /** HLFIP0001_HLFI認証処理 */
    @Autowired
    private Hlfip0001Service hlfip0001Service;
    /** HLFIP0002_HLFI同意取得処理 */
    @Autowired
    private Hlfip0002Service hlfip0002Service;
    /** HLFIP0003_HLFI同意登録更新処理 */
    @Autowired
    private Hlfip0003Service hlfip0003Service;
    /** HLFIP0009_HLFI見積申込作成依頼書初期情報取得処理 */
    @Autowired
    private Hlfip0009Service hlfip0009Service;
    /** ヘルパー */
    @Autowired
    private HLFIS0011Helper helper;
    /** バリデーター */
    @Autowired
    private Validator validator;
    /** プロパティ */
    @Autowired
    private PropertyBean prop;

    /**
     * 初期化処理
     *
     * @param model
     * @param inputForm
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/HLFIS0011")
    public String init(Model model, @ModelAttribute("inputForm") HLFIS0011Form inputForm)
            throws HLFISystemException, Exception {

        logger.info(LoggerUtil.createMsg("START, 初期表示"));

        // 入力パラメータから画面フォーム作成
        HLFIS0011Form outputForm = helper.createForm(inputForm);

        // 認証処理
        hlfip0001Service.authentication();
        helper.transferForm(hlfip0001Service, outputForm);

        // 同意文取得
        List<String> consentDocumentsList = hlfip0009Service.getConsentDocuments();
        if (consentDocumentsList.size() < Integer
                .parseInt(prop.getEnvProp("consent.document.numberofarticle"))) {
            // 同意文書の取得件数が不足
            throw new HLFISystemException("HLFIW0016E",
                    new String[] {String.valueOf(consentDocumentsList.size()),
                            prop.getEnvProp("consent.document.numberofarticle")});

        }

        // 取得した同意文の1～3ファイル目を画面に出力する。
        helper.transferForm(consentDocumentsList, outputForm);

        // 入力・編集分岐
        if ("HLFIS0012".equals(inputForm.getRefGamen())) {
            // 画面モード：編集
            helper.setEditMode("true", outputForm);

            // 同意情報取得
            helper.transferForm(hlfip0002Service.selectConsent(helper.createHlfip0002Model(inputForm)),
                    outputForm);

            // 遷移元の画面を設定する。
            outputForm.setRefGamen(inputForm.getRefGamen());

        } else {
            // 画面モード：入力
            // 同意自署がない場合、空白画像を表示する
            outputForm.setConsentSignSmallCanvas("data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");
            helper.setEditMode("false", outputForm);

        }

        // 画面へ反映する
        model.addAttribute("HLFIS0011Form", outputForm);

        // 自画面へ戻す
        logger.info(LoggerUtil.createMsg("END, 初期表示"));
        return "HLFIS0011";

    }

}
