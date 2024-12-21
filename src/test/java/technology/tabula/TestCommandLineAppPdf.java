package technology.tabula;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONStrFormatter;
import cn.hutool.json.JSONUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import technology.tabula.entity.ExtractObjectEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestCommandLineAppPdf {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private String csvFromCommandLineArgs(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);

        StringBuilder stringBuilder = new StringBuilder();
        new CommandLineApp(stringBuilder, cmd).extractTables(cmd);

        return stringBuilder.toString();
    }

    /**
     * 工商对公-第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfGSDGFirstPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/工商银行对公.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/工商银行对公.pdf",
                "-p", "1", "-f",
                "JSON"
        });
        System.out.println(s);
    }

    /**
     * 工商对公-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfGSDGAllPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/工商银行对公.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/工商银行对公.pdf",
                "-p", "all", "-f",
                "JSON"
        });
        System.out.println(s);
    }


    /**
     * 建行对公-第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfJHDGFirstPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/建行对公.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/建行对公.pdf",
                "-p", "1", "-f",
                "JSON"
        });
        System.out.println(s);
    }

    /**
     * 建行对公-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfJHDGAllPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/建行对公.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/建行对公.pdf",
                "-p", "all", "-f",
                "JSON"
        });
        System.out.println(s);
    }


    /**
     * 建行个人-第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfJHGRFirstPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/建行个人.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/建行个人.pdf",
                "-p", "1", "-f",
                "JSON"
        });
        System.out.println(s);
    }

    /**
     * 建行个人-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfJHGRAllPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/建行个人.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/建行个人.pdf",
                "-p", "all", "-f",
                "JSON"
        });
        System.out.println(s);
    }


    /**
     * 农行个人-第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfNHGRFirstPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/农行个人董秀娟.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/农行个人董秀娟.pdf",
                "-p", "1", "-f",
                "JSON"
        });
        FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                "out\\农行个人董秀娟pdf-json-1-origin.json");
        IoUtil.write(originOutputStream, true, s.getBytes());
        String format = JSONStrFormatter.format(s);
        FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                "out\\农行个人董秀娟pdf-json-1-format.json");
        IoUtil.write(formatOutputStream, true, format.getBytes());
        System.out.println(s);
        System.out.println(format);
    }

    /**
     * 弄行个人-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfNHGRAllPage() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/农行个人董秀娟.pdf");

        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/other/农行个人董秀娟.pdf",
                "-p", "all", "-f",
                "JSON"
        });
        FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                "out\\农行个人董秀娟pdf-json-all-origin.json");
        IoUtil.write(originOutputStream, true, s.getBytes());
        String format = JSONStrFormatter.format(s);
        FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                "out\\农行个人董秀娟pdf-json-all-format.json");
        IoUtil.write(formatOutputStream, true, format.getBytes());
        System.out.println(s);
        System.out.println(format);
    }


    /**
     * 所有银行-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfAllFilesAllPage() throws ParseException, IOException {
        List<String> allFileNames = FileUtil.listFileNames("D:\\work\\opensource\\tabula-java\\src\\test\\resources\\other");
        System.out.println(allFileNames);

        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    System.out.println(fileName + "=====");
                    // fileName = "农行个人董秀娟.pdf"
                    String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    String s = this.csvFromCommandLineArgs(new String[]{
                            "src/test/resources/other/" + fileName,
                            "-p", "all", "-f",
                            "JSON"
                    });
                    FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\所有页\\" + fileNameWithoutSuffix + "pdf-json-all-origin.json");
                    IoUtil.write(originOutputStream, true, s.getBytes());
                    String format = JSONStrFormatter.format(s);
                    FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\所有页\\" + fileNameWithoutSuffix + "pdf-json-all-format.json");
                    IoUtil.write(formatOutputStream, true, format.getBytes());
                    System.out.println(s);
                    System.out.println(format);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(fileName + "，不是pdf格式文档，不解析文件");
            }
        }
    }


    /**
     * 所有银行-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void testExtractPdfAllFilesFirstPage() throws ParseException, IOException {
        List<String> allFileNames = FileUtil.listFileNames("D:\\work\\opensource\\tabula-java\\src\\test\\resources\\other");
        System.out.println(allFileNames);

        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    System.out.println(fileName + "=====");
                    // fileName = "农行个人董秀娟.pdf"
                    String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    String s = this.csvFromCommandLineArgs(new String[]{
                            "src/test/resources/other/" + fileName,
                            "-p", "1", "-f",
                            "JSON"
                    });
                    FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-origin.json");
                    IoUtil.write(originOutputStream, true, s.getBytes());
                    String format = JSONStrFormatter.format(s);
                    FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-format.json");
                    IoUtil.write(formatOutputStream, true, format.getBytes());
                    System.out.println(s);
                    System.out.println(format);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(fileName + "，不是pdf格式文档，不解析文件");
            }
        }
    }


    private static String jsonFromCommandLineArgs(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(CommandLineApp.buildOptions(), args);

        StringBuilder stringBuilder = new StringBuilder();
        new CommandLineApp(stringBuilder, cmd).extractTables(cmd);

        return stringBuilder.toString();
    }


    /**
     * 所有银行-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    public static String testExtractPdfSpecificFileAllPageToDir(String originFileName) throws ParseException, IOException {
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
                    // fileName = "农行个人董秀娟.pdf"
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


    /**
     * 指定文件第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    public static String testExtractPdfSpecificFileFirstPageToDir(String originFileName) {
        // List<String> allFileNames = FileUtil.listFileNames("D:\\work\\opensource\\tabula-java\\src\\test\\resources\\other");
        // System.out.println(allFileNames);
        String s = "";
        List<String> allFileNames = new ArrayList<>();
        allFileNames.add(originFileName);
        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "农行个人董秀娟.pdf"
                    String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    s = jsonFromCommandLineArgs(new String[]{
                            "src/test/resources/other/" + fileName,
                            "-p", "1", "-f",
                            "JSON"
                    });
                    FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-origin.json");
                    IoUtil.write(originOutputStream, true, s.getBytes());
                    String format = JSONStrFormatter.format(s);
                    FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-format.json");
                    IoUtil.write(formatOutputStream, true, format.getBytes());
//                    System.out.println(s);
//                    System.out.println(format);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(fileName + "，不是pdf格式文档，不解析文件");
            }
        }
        return s;
    }


    /**
     * 所有银行-所有页
     *
     * @throws ParseException
     * @throws IOException
     */
    public static String testExtractPdfSpecificFileAllPage(String originFileName) throws ParseException, IOException {
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
                    // fileName = "农行个人董秀娟.pdf"
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


    /**
     * 指定文件第一页
     *
     * @throws ParseException
     * @throws IOException
     */
    public static String testExtractPdfSpecificFileFirstPage(String originFileName) throws ParseException, IOException {
        // List<String> allFileNames = FileUtil.listFileNames("D:\\work\\opensource\\tabula-java\\src\\test\\resources\\other");
        // System.out.println(allFileNames);
        String s = "";
        List<String> allFileNames = new ArrayList<>();
        allFileNames.add(originFileName);
        for (String fileName : allFileNames) {
            if (fileName.endsWith(".pdf")) {
                try {
                    String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf("."));
                    System.out.println(fileName + "=====" + fileNameWithoutSuffix);
                    // fileName = "农行个人董秀娟.pdf"
                    String expectedJson = UtilsForTesting.loadJson("src/test/resources/other/" + fileName);

                    s = jsonFromCommandLineArgs(new String[]{
                            "src/test/resources/other/" + fileName,
                            "-p", "1", "-f",
                            "JSON"
                    });
//                    FileOutputStream originOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
//                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-origin.json");
//                    IoUtil.write(originOutputStream, true, s.getBytes());
//                    String format = JSONStrFormatter.format(s);
//                    FileOutputStream formatOutputStream = new FileOutputStream("C:\\Users\\caoyangfan\\Desktop\\" +
//                            "out\\第一页\\" + fileNameWithoutSuffix + "pdf-json-1-format.json");
//                    IoUtil.write(formatOutputStream, true, format.getBytes());
//                    System.out.println(s);
//                    System.out.println(format);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(fileName + "，不是pdf格式文档，不解析文件");
            }
        }
        return s;
    }


    public static void main(String[] args) {

        String originFileName = "中国银行对公.pdf";
        // 生成指定文件第一页
        // specificFileFirstPage(originFileName);
        // 生成指定文件所有页
        // specificFileAllPage(originFileName);

        // 生成指定文件第一页到指定目录
        testExtractPdfSpecificFileFirstPageToDir(originFileName);

    }

    public static void specificFileFirstPage(String originFileName) {
        try {
            String jsonString = testExtractPdfSpecificFileFirstPage(originFileName);
            System.out.println(jsonString);
            if (JSONUtil.isJson(jsonString)) {
                System.out.println(originFileName + ",返回结构是json格式的字符串");
            }
            JSONArray objects = JSONUtil.parseArray(jsonString);
            for (Object object : objects) {
                System.out.println(object);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void specificFileAllPage(String originFileName) {
        try {
            String jsonString = testExtractPdfSpecificFileAllPage(originFileName);
            System.out.println(jsonString);
            if (JSONUtil.isJson(jsonString)) {
                System.out.println(originFileName + ",返回结构是json格式的字符串");
            }
            List<ExtractObjectEntity> list = JSONUtil.toList(jsonString, ExtractObjectEntity.class);
//            JSONArray objects = JSONUtil.parseArray(jsonString);
//            for (Object object : objects) {
//                System.out.println(object);
//            }
            for (ExtractObjectEntity extractObjectEntity : list) {
                System.out.println(extractObjectEntity);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testExtractSpreadsheetWithArea() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/spreadsheet_no_bounding_frame.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/spreadsheet_no_bounding_frame.pdf",
                "-p", "1", "-a",
                "150.56,58.9,654.7,536.12", "-f",
                "CSV"
        }));
    }

    @Test
    public void testExtractBatchSpreadsheetWithArea() throws ParseException, IOException {
        FileSystem fs = FileSystems.getDefault();
        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/spreadsheet_no_bounding_frame.csv");
        Path tmpFolder = Files.createTempDirectory("tabula-java-batch-test");
        tmpFolder.toFile().deleteOnExit();

        Path copiedPDF = tmpFolder.resolve(fs.getPath("spreadsheet.pdf"));
        Path sourcePDF = fs.getPath("src/test/resources/technology/tabula/spreadsheet_no_bounding_frame.pdf");
        Files.copy(sourcePDF, copiedPDF);
        copiedPDF.toFile().deleteOnExit();

        this.csvFromCommandLineArgs(new String[]{
                "-b", tmpFolder.toString(),
                "-p", "1", "-a",
                "150.56,58.9,654.7,536.12", "-f",
                "CSV"
        });

        Path csvPath = tmpFolder.resolve(fs.getPath("spreadsheet.csv"));
        assertTrue(csvPath.toFile().exists());
        assertArrayEquals(expectedCsv.getBytes(), Files.readAllBytes(csvPath));
    }

    @Test
    public void testExtractSpreadsheetWithAreaAndNewFile() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/spreadsheet_no_bounding_frame.csv");

        File newFile = folder.newFile();
        this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/spreadsheet_no_bounding_frame.pdf",
                "-p", "1", "-a",
                "150.56,58.9,654.7,536.12", "-f",
                "CSV", "-o", newFile.getAbsolutePath()
        });

        assertArrayEquals(expectedCsv.getBytes(), Files.readAllBytes(Paths.get(newFile.getAbsolutePath())));
    }


    @Test
    public void testExtractJSONWithArea() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/technology/tabula/json/spanning_cells_basic.json");

        assertEquals(expectedJson, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/spanning_cells.pdf",
                "-p", "1", "-a",
                "150.56,58.9,654.7,536.12", "-f",
                "JSON"
        }));
    }

    @Test
    public void testExtractCSVWithArea() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/spanning_cells.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/spanning_cells.pdf",
                "-p", "1", "-a",
                "150.56,58.9,654.7,536.12", "-f",
                "CSV"
        }));
    }

    @Test
    public void testGuessOption() throws ParseException, IOException {
        String expectedCsvNoGuessing = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/TestCommandLineApp_testGuessOption_no_guessing.csv");
        assertEquals(expectedCsvNoGuessing, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/icdar2013-dataset/competition-dataset-eu/eu-001.pdf",
                "-p", "1",
                "-f", "CSV"
        }));

        String expectedCsvWithGuessing = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/TestCommandLineApp_testGuessOption_with_guessing.csv");
        assertEquals(expectedCsvWithGuessing, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/icdar2013-dataset/competition-dataset-eu/eu-001.pdf",
                "-p", "1",
                "-f", "CSV",
                "-g"
        }));
    }

    @Test
    public void testEncryptedPasswordSupplied() throws ParseException {
        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/encrypted.pdf",
                "-s", "userpassword",
                "-p", "1",
                "-f", "CSV"
        });
        assertEquals("FLA Audit Profile,,,,,,,,,", s.split("\\r?\\n")[0]);
    }

    @Test(expected = ParseException.class)
    public void testEncryptedWrongPassword() throws ParseException {
        String s = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/encrypted.pdf",
                "-s", "wrongpassword",
                "-p", "1",
                "-f", "CSV"
        });
    }

    @Test
    public void testExtractWithMultiplePercentArea() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/MultiColumn.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/MultiColumn.pdf",
                "-p", "1", "-a",
                "%0,0,100,50", "-a",
                "%0,50,100,100", "-f",
                "CSV"
        }));
    }

    @Test
    public void testExtractWithMultipleAbsoluteArea() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/MultiColumn.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/MultiColumn.pdf",
                "-p", "1", "-a",
                "0,0,451,212", "-a",
                "0,212,451,425", "-f",
                "CSV"
        }));
    }

    @Test
    public void testExtractWithPercentAndAbsoluteArea() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/MultiColumn.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/MultiColumn.pdf",
                "-p", "1", "-a",
                "%0,0,100,50", "-a",
                "0,212,451,425", "-f",
                "CSV"
        }));
    }

    @Test
    public void testLatticeModeWithColumnOption() throws ParseException, IOException {

        String expectedCsv = UtilsForTesting.loadCsv("src/test/resources/technology/tabula/csv/AnimalSounds.csv");

        assertEquals(expectedCsv, this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/AnimalSounds.pdf",
                "-p", "1", "-c",
                "59,218,331,551",
                "-r", "-f", "CSV"
        }));
    }

    @Test
    public void testLatticeModeWithColumnAndMultipleAreasOption() throws ParseException, IOException {

        String expectedJson = UtilsForTesting.loadJson("src/test/resources/technology/tabula/json/AnimalSounds1.json");
        String resultJson = this.csvFromCommandLineArgs(new String[]{
                "src/test/resources/technology/tabula/AnimalSounds1.pdf",
                "-p", "1", "-c", "57,136,197,296,314,391,457,553",
                "-a", "%0,0,100,50", "-a", "%0,50,100,100",
                "-r", "-f", "JSON"
        });
        assertEquals(expectedJson, resultJson);
    }

}
