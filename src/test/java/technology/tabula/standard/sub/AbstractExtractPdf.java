package technology.tabula.standard.sub;

import cn.hutool.json.JSONUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import technology.tabula.CommandLineApp;
import technology.tabula.UtilsForTesting;
import technology.tabula.entity.ExtractObjectEntity;
import technology.tabula.standard.ExtractPdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽取pdf
 */
public abstract class AbstractExtractPdf<T> implements ExtractPdf<T> {

    @Override
    public void start(String fileName) {
        String pdfFileJsonStr = extractPdfToJson(fileName);
        List<ExtractObjectEntity> dataList = convertJsonToList(pdfFileJsonStr);
        System.out.println("处理数据前：" + dataList);
        List<T> processedDatas = processData(dataList);
        System.out.println("处理数据后：" + processedDatas);
        batchSaveToDatabase(processedDatas);
    }

    @Override
    public String extractPdfToJson(String pdfFile) {
        String pdfFileJsonStr = "";
        try {
            pdfFileJsonStr = extractPdfSpecificFileAllPage(pdfFile);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pdfFileJsonStr;

    }

    @Override
    public List<ExtractObjectEntity> convertJsonToList(String jsonString) {
        System.out.println(jsonString);
        if (JSONUtil.isJson(jsonString)) {
            System.out.println("返回结构是json格式的字符串");
        }
        if (JSONUtil.isJsonArray(jsonString)) {
            System.out.println("返回结构是jsonArray格式的字符串");
        }
        // JSONArray objects = JSONUtil.parseArray(jsonString);
        List<ExtractObjectEntity> list = JSONUtil.toList(jsonString, ExtractObjectEntity.class);

        return list;
    }

    /**
     * 指定文件所有页数据
     *
     * @throws ParseException
     * @throws IOException
     */
    public String extractPdfSpecificFileAllPage(String originFileName) throws ParseException, IOException {
        // List<String> allFileNames = FileUtil.listFileNames("D:\\work\\opensource\\tabula-java\\src\\test\\resources\\other");
        String s = "";
        List<String> allFileNames = new ArrayList<>();
        System.out.println(originFileName);
        allFileNames.add(originFileName);

        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "xxx.pdf"
                    String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    s = jsonFromCommandLineArgs(new String[]{
                            "src/test/resources/other/" + fileName,
                            "-p", "all", "-f",
                            "JSON"
                    });
                    /*FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\所有页\\" + fileNameWithoutSuffix + "pdf-json-all-origin.json");
                    IoUtil.write(originOutputStream, true, s.getBytes());
                    String format = JSONStrFormatter.format(s);
                    FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\所有页\\" + fileNameWithoutSuffix + "pdf-json-all-format.json");
                    IoUtil.write(formatOutputStream, true, format.getBytes());
                    System.out.println(s);
                    System.out.println(format);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(fileName + "，不是pdf格式文档，不解析文件");
            }
        }
        return s;
    }


    private static String jsonFromCommandLineArgs(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);

        StringBuilder stringBuilder = new StringBuilder();
        new CommandLineApp(stringBuilder, cmd).extractTables(cmd);

        return stringBuilder.toString();
    }

}


