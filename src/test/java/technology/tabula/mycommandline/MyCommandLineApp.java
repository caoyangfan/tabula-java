package technology.tabula.mycommandline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import technology.tabula.CommandLineApp;

import java.io.File;

/**
 * 重写 extractTables() 方法，实现上传文件源
 */
public class MyCommandLineApp extends CommandLineApp {

    public MyCommandLineApp(Appendable defaultOutput, CommandLine line) throws ParseException {
        super(defaultOutput, line);
    }

    public void extractTables(CommandLine line, File pdfFile) throws ParseException {
        // 批量上传未重写，还需要传递路径
        if (line.hasOption('b')) {
            if (line.getArgs().length != 0) {
                throw new ParseException("Filename specified with batch\nTry --help for help");
            } else {
                pdfFile = new File(line.getOptionValue('b'));
                if (!pdfFile.isDirectory()) {
                    throw new ParseException("Directory does not exist or is not a directory");
                } else {
                    this.extractDirectoryTables(line, pdfFile);
                }
            }
        } else if (line.getArgs().length != 1 && pdfFile == null) {
            throw new ParseException("Need exactly one filename\nTry --help for help");
        } else {
            if (!pdfFile.exists()) {
                throw new ParseException("File does not exist");
            } else {
                this.extractFileTables(line, pdfFile);
            }
        }
    }
}

