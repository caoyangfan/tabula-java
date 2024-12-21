package technology.tabula.filestrategy.factory;

import technology.tabula.filestrategy.FileExtractStrategy;
import technology.tabula.filestrategy.ccb.CCBDGFileExtractStrategy;
import technology.tabula.filestrategy.ccb.CCBGRFileExtractStrategy;
import technology.tabula.filestrategy.defaultstrategy.DefaultFileExtractStrategy;
import technology.tabula.filestrategy.enums.FileTemplateTypeEnum;
import technology.tabula.filestrategy.icbc.ICBCDGFileExtractStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileExtractStrategyFactory {

    private static Map<String, FileExtractStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put(FileTemplateTypeEnum.ICBC_DG.getCode(), new ICBCDGFileExtractStrategy());
        STRATEGY_MAP.put(FileTemplateTypeEnum.ICBC_GR.getCode(), new ICBCDGFileExtractStrategy());
        STRATEGY_MAP.put(FileTemplateTypeEnum.CCB_DG.getCode(), new CCBDGFileExtractStrategy());
        STRATEGY_MAP.put(FileTemplateTypeEnum.CCB_GR.getCode(), new CCBGRFileExtractStrategy());
        STRATEGY_MAP.put(FileTemplateTypeEnum.DEFAULT.getCode(), new DefaultFileExtractStrategy());
    }

    private FileExtractStrategyFactory() {
    }

    public static FileExtractStrategy getFileExtractStrategy(String templateType) {
        if (!STRATEGY_MAP.containsKey(templateType)) {
            return STRATEGY_MAP.get(FileTemplateType.DEFAULT);
        }
        return STRATEGY_MAP.get(templateType);
    }

    private interface FileTemplateType {
        String ICBC_DG = "ICBC_DG";
        String ICBC_GR = "ICBC_GR";
        String CCB_DG = "CCB_DG";
        String CCB_GR = "CCB_GR";
        String ABC_DG = "ABC_DG";
        String ABC_GR = "ABC_GR";
        String BOC_GR = "BOC_GR";
        String BOC_DG = "BOC_DG";
        String WECHAT = "WECHAT";
        String DEFAULT = "DEFAULT";
    }

    public static Set<String> getFileTemplateKeys() {
        return STRATEGY_MAP.keySet();
    }


    public static void main(String[] args) {
        // String fileTemplateTypeKey = FileTemplateTypeEnum.DEFAULT.getCode();
        String fileTemplateTypeKey = FileTemplateTypeEnum.ICBC_DG.getCode();
        FileExtractStrategy strategy = FileExtractStrategyFactory.getFileExtractStrategy(fileTemplateTypeKey);
        String pdfFile = "src/test/resources/other/工商银行对公.pdf";
        strategy.readPdf(pdfFile);
    }

}
