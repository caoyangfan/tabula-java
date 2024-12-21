package technology.tabula.filestrategy;

/**
 * 文件抽取接口类
 */
public interface FileExtractStrategy {

    /**
     * 文件模板名称
     */
    void getFileTemplateName();

    /**
     * 读取pdf文件
     *
     * @param fileName
     */
    void readPdf(String fileName);

}
