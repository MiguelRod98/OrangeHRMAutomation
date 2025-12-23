package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.choucair.userInterfaces.PIMPage.ADD_EMPLOYEE_BUTTON;

public class GoToAddEmployee implements Task {

    public static GoToAddEmployee option() {
        return instrumented(GoToAddEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ADD_EMPLOYEE_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ADD_EMPLOYEE_BUTTON)
        );
    }
}