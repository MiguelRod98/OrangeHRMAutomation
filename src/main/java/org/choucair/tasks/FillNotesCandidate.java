package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ShortlistCandidatePage.*;

public class FillNotesCandidate implements Task {

    public static FillNotesCandidate addNotes() {

        return instrumented(FillNotesCandidate.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue("Notes candidate").into(NOTES_TEXTAREA),
                Click.on(SAVE_BUTTON)
        );
    }
}
