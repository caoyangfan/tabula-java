package technology.tabula.standard.sub;

import cn.hutool.json.JSONUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import technology.tabula.CommandLineApp;
import technology.tabula.entity.ExtractObjectEntity;
import technology.tabula.mycommandline.MyCommandLineApp;
import technology.tabula.standard.ExtractPdf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽取pdf
 */
public abstract class AbstractExtractPdf<T> implements ExtractPdf<T> {

    @Override
    public void execute(String fileName) {
        String pdfFileJsonStr = extractPdfFilePathToJson(fileName);
        List<ExtractObjectEntity> dataList = convertJsonToList(pdfFileJsonStr);
        System.out.println("处理数据前：" + dataList);
        List<T> processedDatas = processData(dataList);
        System.out.println("处理数据后：" + processedDatas);
        batchSaveToDatabase(processedDatas);
    }

    @Override
    public void execute(File file) {
        String pdfFileJsonStr = extractPdfFileToJson(file);
        List<ExtractObjectEntity> dataList = convertJsonToList(pdfFileJsonStr);
        System.out.println("处理数据前：" + dataList);
        List<T> processedDatas = processData(dataList);
        System.out.println("处理数据后：" + processedDatas);
        batchSaveToDatabase(processedDatas);
    }

    @Override
    public void execute(InputStream inputStream) {
        String pdfFileJsonStr = extractPdfInputStreamToJson(inputStream);
        List<ExtractObjectEntity> dataList = convertJsonToList(pdfFileJsonStr);
        System.out.println("处理数据前：" + dataList);
        List<T> processedDatas = processData(dataList);
        System.out.println("处理数据后：" + processedDatas);
        batchSaveToDatabase(processedDatas);
    }

    @Override
    public String extractPdfFilePathToJson(String pdfFile) {
        String pdfFileJsonStr = "";
        try {
            pdfFileJsonStr = extractPdfSpecificFilePathAllPage(pdfFile);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pdfFileJsonStr;
    }

    @Override
    public String extractPdfFileToJson(File pdfFile) {
        String pdfFileJsonStr = "";
        try {
            pdfFileJsonStr = extractPdfSpecificFileAllPageByFile(pdfFile);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pdfFileJsonStr;
    }


    @Override
    public String extractPdfInputStreamToJson(InputStream inputStream) {
        String pdfFileJsonStr = "";
        try {
            pdfFileJsonStr = extractPdfSpecificFileAllPageByInputStream(inputStream);
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
     * 指定文件路径所有页数据
     *
     * @throws ParseException
     * @throws IOException
     */
    public String extractPdfSpecificFilePathAllPage(String originFileName) throws ParseException, IOException {
        String jsonStr = "";
        List<String> allFileNames = new ArrayList<>();
        System.out.println(originFileName);
        allFileNames.add(originFileName);

        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    // System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "xxx.pdf"
                    // String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    jsonStr = jsonFromCommandLineArgs(new String[]{
                            fileName,
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
        return jsonStr;
    }


    /**
     * 指定文件流所有页数据
     *
     * @throws ParseException
     * @throws IOException
     */
    public String extractPdfSpecificFileAllPageByInputStream(InputStream inputStream) throws ParseException, IOException {
        StringBuilder jsonData = new StringBuilder();
        File file = File.createTempFile("tmp", "pdf");
        inputStreamToFile(inputStream, file);
        List<File> allFiles = new ArrayList<>();
        allFiles.add(file);

        for (File file1 : allFiles) {
            String fileName = file1.getName();
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    // System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "xxx.pdf"
                    // String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    jsonData = jsonFromCommandLineArgsByFile(new String[]{
                            "-p", "all", "-f",
                            "JSON"
                    }, file);

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
        return jsonData.toString();
    }

    /**
     * 指定文件所有页数据
     *
     * @throws ParseException
     * @throws IOException
     */
    public String extractPdfSpecificFileAllPageByFile(File file) throws ParseException, IOException {
        StringBuilder jsonData = new StringBuilder();
        List<File> allFiles = new ArrayList<>();
        allFiles.add(file);

        for (File file1 : allFiles) {
            String fileName = file1.getName();
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    // System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "xxx.pdf"
                    // String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    jsonData = jsonFromCommandLineArgsByFile(new String[]{
                            "-p", "all", "-f",
                            "JSON"
                    }, file);

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
        return jsonData.toString();
    }


    private static String jsonFromCommandLineArgs(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);

        StringBuilder stringBuilder = new StringBuilder();
        new CommandLineApp(stringBuilder, cmd).extractTables(cmd);

        return stringBuilder.toString();
    }


    private static StringBuilder jsonFromCommandLineArgsByFile(String[] args, File file) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);
        StringBuilder stringBuilder = new StringBuilder();
        new MyCommandLineApp(stringBuilder, cmd).extractTables(cmd, file);
        return stringBuilder;
    }

    /**
     * 输入流转文件
     *
     * @param ins
     * @param file
     */
    public static void inputStreamToFile(InputStream ins, File file) throws IOException {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = new BufferedInputStream(ins);
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                }
                ins = null;
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                }
                bos = null;
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                }
                bis = null;
            }
        }
    }


}


