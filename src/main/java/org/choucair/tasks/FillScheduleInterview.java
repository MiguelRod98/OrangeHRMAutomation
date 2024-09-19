package org.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ScheduleInterviewPage.*;
import static org.choucair.userInterfaces.ShortlistCandidatePage.*;

public class FillScheduleInterview implements Task {

    public static FillScheduleInterview addDataInterview() {

        return instrumented(FillScheduleInterview.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue("OrangeHRM Interview").into(TITLE_INPUT),
                Enter.theValue("P").into(INTERVIEWER_INPUT),
                WaitUntil.the(INTERVIEWER_OPTION, WebElementStateMatchers.containsText("P"))
                        .forNoMoreThan(10L)
                        .seconds(),
                Click.on(INTERVIEWER_OPTION),
                Enter.theValue(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM"))).into(DATE_INPUT),
                Enter.theValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"))).into(TIME_INPUT),
                Enter.theValue("Notes candidate").into(NOTES_TEXTAREA),
                Click.on(SAVE_BUTTON)
        );
    }
}
