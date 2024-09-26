package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Candidate;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.ScheduleInterviewPage.*;
import static org.choucair.userInterfaces.ShortlistCandidatePage.*;

@AllArgsConstructor
public class FillScheduleInterview implements Task {

    private final List<Candidate> candidate;

    public static FillScheduleInterview addDataInterview(List<Candidate> candidate) {

        return instrumented(FillScheduleInterview.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(TITLE_INPUT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10L)
                        .seconds(),
                Enter.theValue(candidate.get(0).getTittleInterview()).into(TITLE_INPUT),
                WaitUntil.the(INTERVIEWER_INPUT, WebElementStateMatchers.isCurrentlyVisible())
                        .forNoMoreThan(10L)
                        .seconds(),
                Enter.theValue(candidate.get(0).getInterviewer()).into(INTERVIEWER_INPUT),
                WaitUntil.the(INTERVIEWER_OPTION, WebElementStateMatchers.containsText(candidate.get(0).getInterviewer()))
                        .forNoMoreThan(10L)
                        .seconds(),
                Click.on(INTERVIEWER_OPTION),
                Enter.theValue(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).into(DATE_INPUT),
                Enter.theValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"))).into(TIME_INPUT),
                Enter.theValue(candidate.get(0).getNotes()).into(NOTES_TEXTAREA),
                Click.on(SAVE_BUTTON)
        );
    }
}
