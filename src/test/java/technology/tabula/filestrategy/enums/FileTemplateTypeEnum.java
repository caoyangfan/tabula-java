package technology.tabula.filestrategy.enums;

public enum FileTemplateTypeEnum {
    ICBC_DG("gsyh_dg", "工商银行对公", "工商银行对公"),
    ICBC_GR("gsyh_gr", "工商银行个人", "工商银行个人"),
    CCB_DG("jsyh_dg", "建设银行对公", "建设银行对公"),
    CCB_GR("jsyh_gr", "建设银行个人", "建设银行个人"),
    ABC_DG("nyyh_dg", "农业银行对公", "农业银行对公"),
    ABC_GR("nyyh_gr", "农业银行个人", "农业银行个人"),
    WECHAT("nyyh_gr", "微信支付交易明细", "微信支付交易明细"),
    BOC_GR("zgyh_gr", "中国银行个人", "中国银行个人"),
    BOC_DG("zgyh_dg", "中国银行对公", "中国银行对公"),
    DEFAULT("DEFAULT", "默认", "默认"),
    ;


    String code;
    String name;
    String desc;

    FileTemplateTypeEnum(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
