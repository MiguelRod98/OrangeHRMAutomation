package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Candidate;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ShortlistCandidatePage.*;

@AllArgsConstructor
public class FillNotesCandidate implements Task {

    private final List<Candidate> candidate;

    public static FillNotesCandidate addNotes(List<Candidate> candidate) {

        return instrumented(FillNotesCandidate.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SAVE_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10L)
                        .seconds(),
                Enter.theValue(candidate.get(0).getNotes()).into(NOTES_TEXTAREA),
                Click.on(SAVE_BUTTON)
        );
    }
}
