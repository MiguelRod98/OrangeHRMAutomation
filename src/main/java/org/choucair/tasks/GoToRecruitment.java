package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.MenuPage.*;
import static org.choucair.userInterfaces.ViewCandidatesPage.*;

public class GoToRecruitment implements Task {

    public static GoToRecruitment recruitmentItemMenu() {

        return instrumented(GoToRecruitment.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(RECRUITMENT_MENU_ITEM),
                Scroll.to(ADD_USER_BUTTON).andAlignToBottom()
        );
    }
}
