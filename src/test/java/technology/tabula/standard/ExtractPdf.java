package technology.tabula.standard;

import technology.tabula.entity.ExtractObjectEntity;

import java.util.List;

/**
 * @author caoyangfan
 * @date 2024-12-20 18:19:57
 */
public interface ExtractPdf<T> {

    void start(String fileName);

    String extractPdfToJson(String pdfFile);

    List<ExtractObjectEntity> convertJsonToList(String pdfFileJsonStr);

    List<T> processData(List<ExtractObjectEntity> dataList);

    void batchSaveToDatabase(List<T> dataList);

}