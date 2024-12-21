package technology.tabula.filestrategy.defaultstrategy;

import technology.tabula.filestrategy.FileExtractStrategy;
import technology.tabula.filestrategy.enums.FileTemplateTypeEnum;

public class DefaultFileExtractStrategy implements FileExtractStrategy {
    @Override
    public void getFileTemplateName() {
        FileTemplateTypeEnum.DEFAULT.getName();
    }

    @Override
    public void readPdf(String fileName) {
        System.out.println("没有对应的模版处理方法");
    }
}
