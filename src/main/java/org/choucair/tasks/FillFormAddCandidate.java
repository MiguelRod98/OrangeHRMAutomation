package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Candidate;

import java.nio.file.Paths;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.AddCandidatePage.*;

@AllArgsConstructor
public class FillFormAddCandidate implements Task {

    private final List<Candidate> candidate;

    public static FillFormAddCandidate withTheData(List<Candidate> candidate) {

        return instrumented(FillFormAddCandidate.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(FIRST_NAME_INPUT, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(10L)
                                .seconds(),
                Enter.theValue(candidate.get(0).getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(candidate.get(0).getMiddleName()).into(MIDDLE_NAME_INPUT),
                Enter.theValue(candidate.get(0).getLastName()).into(LAST_NAME_INPUT),
                Click.on(VACANCY_DROPDOWN),
                Click.on(VACANCY_WITH_OPTION.of(candidate.get(0).getVacancy())),
                Enter.theValue(candidate.get(0).getEmail()).into(EMAIL_INPUT),
                Enter.theValue(candidate.get(0).getPhone()).into(PHONE_INPUT),
                Upload.theFile(Paths.get(candidate.get(0).getCv())).to(CV_INPUT),
                Enter.theValue(candidate.get(0).getKeywords()).into(KEYWORDS_INPUT),
                Enter.theValue(candidate.get(0).getNotes()).into(NOTES_INPUT),
                Click.on(CONSENT_CHECKBOX),
                Click.on(SAVE_BUTTON)
        );
    }
}
