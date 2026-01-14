package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import starter.questions.GetTransactionInfo;
import starter.ui.addtransaction.AddTransactionPage;

public class CheckNewTransactionWasAdded implements Task {

    public final String valueDescription;
    public final String valueAmount;
    public CheckNewTransactionWasAdded(String valueDescription, String valueAmount) {
        this.valueDescription = valueDescription;
        this.valueAmount = valueAmount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(GetTransactionInfo.getDescription()).contains(this.valueDescription),
                Ensure.that(AddTransactionPage.TRANSACTIONS_TABLE)
                        .text().contains(this.valueAmount)
        );
    }
}
