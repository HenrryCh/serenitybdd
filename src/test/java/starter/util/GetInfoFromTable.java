package starter.util;

import io.cucumber.datatable.DataTable;
import starter.models.LoginModel;
import starter.models.TransactionModel;

import java.util.List;

public class GetInfoFromTable {

    public static LoginModel getLoginCredentials(DataTable userLogin) {
        List<List<String>> rows = userLogin.asLists(String.class);

        String username = "";
        String password = "";

        for(List<String> colums : rows) {
            username = colums.get(0);
            password = colums.get(1);
        }
        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);

        return loginModel;
    }

    public static TransactionModel getTransactionDate(DataTable transactionInfo) {
        List<List<String>> rows = transactionInfo.asLists(String.class);

        String transactionDate = "";
        String transactionAmount = "";
        String transactionDescription = "";

        for(List<String> colums : rows) {
            transactionDate = colums.get(0);
            transactionAmount = colums.get(1);
            transactionDescription = colums.get(2);
        }
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTransactionDate(transactionDate);
        transactionModel.setTransactionAmount(transactionAmount);
        transactionModel.setTransactionDescription(transactionDescription);

        return transactionModel;
    }
}
