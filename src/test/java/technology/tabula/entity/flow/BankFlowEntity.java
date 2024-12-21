package technology.tabula.entity.flow;

public class BankFlowEntity {

    /**
     * 凭证号
     */
    private String voucherNumber;

    /**
     * 本方账号  The other party's account
     */
    private String fromAccount;

    /**
     * 对方账号  The other party's account
     */
    private String toAccount;

    /**
     * 交易时间 Transaction time
     */
    private String transactionTime;

    /**
     * transaction type
     * Debit/Loan   借/贷
     */
    private String transactionType;

    /**
     * Debit amount 借方发生额
     */
    private String debitAmount;

    /**
     * 贷方发生额 (creditAmount)
     */
    private String loanAmount;

    /**
     * 对方行号 The other party's bank number
     */
    private String toBankNumber;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 对方单位名称
     */
    private String toCompanyName;

    /**
     * 余额
     */
    private String balance;

    /**
     * 个性化信息
     */
    private String personnelInformation;

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getToBankNumber() {
        return toBankNumber;
    }

    public void setToBankNumber(String toBankNumber) {
        this.toBankNumber = toBankNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getToCompanyName() {
        return toCompanyName;
    }

    public void setToCompanyName(String toCompanyName) {
        this.toCompanyName = toCompanyName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPersonnelInformation() {
        return personnelInformation;
    }

    public void setPersonnelInformation(String personnelInformation) {
        this.personnelInformation = personnelInformation;
    }
}
