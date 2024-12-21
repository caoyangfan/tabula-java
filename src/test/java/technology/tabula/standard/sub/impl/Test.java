package technology.tabula.standard.sub.impl;

public class Test {
    public static void main(String[] args) {
        ICBCPublicExtractPdf publicExtractPdf = new ICBCPublicExtractPdf();
        String pdfFile = "工商银行对公.pdf";
        publicExtractPdf.execute(pdfFile);
    }
}
