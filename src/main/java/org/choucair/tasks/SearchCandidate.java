package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ScheduleInterviewPage.*;
import static org.choucair.userInterfaces.ViewCandidatesPage.*;

public class SearchCandidate implements Task {

    public static SearchCandidate byName() {

        return instrumented(SearchCandidate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue("Anderson").into(CANDIDATE_NAME_SEARCH),
                WaitUntil.the(INTERVIEWER_OPTION, WebElementStateMatchers.containsText("Anderson"))
                        .forNoMoreThan(10L)
                        .seconds(),
                Click.on(INTERVIEWER_OPTION),
                Click.on(SEARCH_CANDIDATE_BUTTON),
                WaitUntil.the(CANDIDATE_CHECKBOX, WebElementStateMatchers.isNotSelected())
                        .forNoMoreThan(10L)
                        .seconds()
                        .then(Scroll.to(CANDIDATE_CHECKBOX)),
                Click.on(CANDIDATE_CHECKBOX)
        );
    }
}
