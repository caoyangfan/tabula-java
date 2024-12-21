package technology.tabula.filestrategy.ccb;

import technology.tabula.filestrategy.FileExtractStrategy;
import technology.tabula.filestrategy.enums.FileTemplateTypeEnum;

/**
 * 建设银行
 */
public class CCBDGFileExtractStrategy implements FileExtractStrategy {

    @Override
    public void getFileTemplateName() {
        FileTemplateTypeEnum.CCB_DG.getName();
    }

    @Override
    public void readPdf(String fileName) {

    }
}
