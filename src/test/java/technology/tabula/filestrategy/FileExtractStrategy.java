package technology.tabula.filestrategy;

/**
 * 文件抽取接口类
 */
public interface FileExtractStrategy {
    void getFileTemplateName();

    void readPdf(String fileName);
}
