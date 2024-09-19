package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ViewCandidatesPage.*;

@AllArgsConstructor
public class GoToAddCandidate implements Task {

    public static GoToAddCandidate addCandidateOption() {

        return instrumented(GoToAddCandidate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(ADD_USER_BUTTON)
        );
    }
}
