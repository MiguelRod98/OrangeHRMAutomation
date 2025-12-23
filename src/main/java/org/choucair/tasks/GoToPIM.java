package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.choucair.userInterfaces.MenuPage.PIM_MENU_ITEM;

public class GoToPIM implements Task {

    public static GoToPIM module() {
        return instrumented(GoToPIM.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PIM_MENU_ITEM, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PIM_MENU_ITEM)
        );
    }
}