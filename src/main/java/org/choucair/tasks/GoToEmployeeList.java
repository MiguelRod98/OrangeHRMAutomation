package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.choucair.userInterfaces.PIMPage.EMPLOYEE_LIST_MENU;

public class GoToEmployeeList implements Task {

    public static GoToEmployeeList option() {
        return instrumented(GoToEmployeeList.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EMPLOYEE_LIST_MENU, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(EMPLOYEE_LIST_MENU)
        );
    }
}