package technology.tabula.standard.sub.impl;

import technology.tabula.entity.ExtractObjectEntity;
import technology.tabula.standard.sub.AbstractExtractPdf;

import java.util.List;

/**
 * 工商银行对公抽取pdf
 */
public class ICBCPublicExtractPdf extends AbstractExtractPdf<ExtractObjectEntity> {

    @Override
    public List<ExtractObjectEntity> processData(List<ExtractObjectEntity> dataList) {
        return dataList;
    }

    @Override
    public void batchSaveToDatabase(List<ExtractObjectEntity> dataList) {
        System.out.println(dataList);
    }

}


