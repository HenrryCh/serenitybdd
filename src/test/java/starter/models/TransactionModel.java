package starter.models;

public class TransactionModel {
    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDescription() {
        return TransactionDescription;
    }

    public void setTransactionDescription(String getTransactionDescription) {
        this.TransactionDescription = getTransactionDescription;
    }

    private String TransactionDate;
    private String transactionAmount;
    private String TransactionDescription;


}
