package technology.tabula.standard.sub.impl;

import cn.hutool.core.collection.CollectionUtil;
import technology.tabula.entity.ExtractObjectEntity;
import technology.tabula.entity.FieldEntity;
import technology.tabula.entity.flow.BankFlowEntity;
import technology.tabula.standard.sub.AbstractExtractPdf;

import java.util.List;

/**
 * 工商银行对公抽取pdf
 */
public class ICBCPublicExtractPdf extends AbstractExtractPdf<BankFlowEntity> {

    @Override
    public List<BankFlowEntity> processData(List<ExtractObjectEntity> dataList) {
        List<BankFlowEntity> flowEntities = convertData(dataList);
        return flowEntities;
    }

    @Override
    public void batchSaveToDatabase(List<BankFlowEntity> dataList) {
        System.out.println(dataList);
    }

    /**
     * 不同模板提取表格数据不一样，具体模版写在这里
     *
     * @param dataList
     * @return
     */
    public List<BankFlowEntity> convertData(List<ExtractObjectEntity> dataList) {
        List<BankFlowEntity> flowEntityList = CollectionUtil.newArrayList();
        if (CollectionUtil.isNotEmpty(dataList)) {
            for (ExtractObjectEntity entity : dataList) {
                List<List<FieldEntity>> data = entity.getData();
                if (CollectionUtil.isNotEmpty(data)) {
                    for (int i = 1; i < data.size(); i++) {
                        List<FieldEntity> fieldData = data.get(i);
                        BankFlowEntity entity1 = new BankFlowEntity();
                        entity1.setVoucherNumber(fieldData.get(0).getText());
                        entity1.setFromAccount(fieldData.get(1).getText());
                        entity1.setToAccount(fieldData.get(2).getText());
                        entity1.setTransactionTime(fieldData.get(3).getText());
                        entity1.setTransactionType(fieldData.get(4).getText());
                        entity1.setDebitAmount(fieldData.get(5).getText());
                        entity1.setLoanAmount(fieldData.get(6).getText());
                        entity1.setToBankNumber(fieldData.get(7).getText());
                        entity1.setSummary(fieldData.get(8).getText());
                        entity1.setPurpose(fieldData.get(9).getText());
                        entity1.setToCompanyName(fieldData.get(10).getText());
                        entity1.setBalance(fieldData.get(11).getText());
                        entity1.setPersonnelInformation(fieldData.get(12).getText());
                        flowEntityList.add(entity1);
                    }
                }
            }

        }
        return flowEntityList;
    }

}


