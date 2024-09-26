package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Candidate;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ScheduleInterviewPage.*;
import static org.choucair.userInterfaces.ViewCandidatesPage.*;

@AllArgsConstructor
public class SearchCandidate implements Task {

    private final List<Candidate> candidate;

    public static SearchCandidate byName(List<Candidate> candidate) {

        return instrumented(SearchCandidate.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(CANDIDATE_NAME_SEARCH, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10L)
                        .seconds(),
                Enter.theValue(candidate.get(0).getFirstName()).into(CANDIDATE_NAME_SEARCH),
                WaitUntil.the(INTERVIEWER_OPTION, WebElementStateMatchers.containsText(candidate.get(0).getFirstName()))
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
