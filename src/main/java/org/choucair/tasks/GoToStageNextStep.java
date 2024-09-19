package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ApplicationStagePage.*;

@AllArgsConstructor
public class GoToStageNextStep implements Task {

    private final Target buttonToClick;

    public static GoToStageNextStep successOption() {

        return instrumented(GoToStageNextStep.class, SUCCESS_STAGE_BUTTON);
    }

    public static GoToStageNextStep successOfferJobOption() {

        return instrumented(GoToStageNextStep.class, SUCCESS_STAGE_OFFER_JOB_BUTTON);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(buttonToClick)
        );
    }
}
