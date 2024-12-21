package technology.tabula.standard;

import technology.tabula.entity.ExtractObjectEntity;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @author caoyangfan
 * @date 2024-12-20 18:19:57
 */
public interface ExtractPdf<T> {

    void execute(String fileName);

    void execute(File file);

    void execute(InputStream inputStream);

    String extractPdfFilePathToJson(String pdfFile);

    String extractPdfFileToJson(File pdfFile);

    String extractPdfInputStreamToJson(InputStream pdfFile);

    List<ExtractObjectEntity> convertJsonToList(String pdfFileJsonStr);

    List<T> processData(List<ExtractObjectEntity> dataList);

    void batchSaveToDatabase(List<T> dataList);

}