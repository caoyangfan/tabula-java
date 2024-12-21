package technology.tabula.filestrategy.icbc;

import technology.tabula.standard.sub.impl.ICBCPublicExtractPdf;

public class ICBCDGFileExtractStrategy extends AbstractICBCFileExtractStrategy {
    @Override
    public void getFileTemplateName() {

    }

    @Override
    public void readPdf(String fileName) {
        ICBCPublicExtractPdf extractPdf = new ICBCPublicExtractPdf();
        extractPdf.start(fileName);
    }
}
