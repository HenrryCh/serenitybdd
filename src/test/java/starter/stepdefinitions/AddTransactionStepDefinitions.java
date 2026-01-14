package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.addtransaction.AddTransaction;
import starter.tasks.addtransaction.CheckNewTransactionWasAdded;
import starter.tasks.login.Login;
import starter.tasks.navigation.NavegateTo;
import starter.tasks.registration.CheckNewAccountCreated;
import starter.ui.addtransaction.AddTransactionPage;
import starter.util.GetInfoFromTable;

import java.util.List;

public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin) {

        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);
        actor.attemptsTo(
                NavegateTo.loginPage(),
                new Login(loginModel.getUsername(), loginModel.getPassword())
        );
    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable transactionInfo) {

        TransactionModel transactionModel = GetInfoFromTable.getTransactionDate(transactionInfo);
        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getTransactionDate(),transactionModel.getTransactionAmount(),transactionModel.getTransactionDescription())
        );
    }

    @Then("{actor} should see a new transaction in the transaction list with correte details")
    public void shouldSeeTheNewTransactionInTheTransactionListWithCorrectDetails(Actor actor, DataTable transactionInfoValue) {

        List<List<String>> rows = transactionInfoValue.asLists(String.class);

        String valueDescription = "";
        String valueAmount = "";

        for(List<String> colums : rows) {
            valueDescription = colums.get(0);
            valueAmount = colums.get(1);
        }
        actor.attemptsTo(
            new CheckNewTransactionWasAdded(valueDescription,valueAmount)
        );
    }


}
