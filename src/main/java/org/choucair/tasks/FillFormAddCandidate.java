package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import org.choucair.models.Candidate;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.AddCandidatePage.*;

@AllArgsConstructor
public class FillFormAddCandidate implements Task {

    private final Candidate candidate;

    public static FillFormAddCandidate withTheData(Candidate candidate) {

        return instrumented(FillFormAddCandidate.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue(candidate.getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(candidate.getMiddleName()).into(MIDDLE_NAME_INPUT),
                Enter.theValue(candidate.getLastName()).into(LAST_NAME_INPUT),
                Click.on(VACANCY_DROPDOWN),
                Click.on(VACANCY_WITH_OPTION.of("Payroll Administrator")),
                Enter.theValue(candidate.getEmail()).into(EMAIL_INPUT),
                Enter.theValue(candidate.getPhone()).into(PHONE_INPUT),
                Upload.theFile(Paths.get("src/test/resources/files/CV.txt")).to(CV_INPUT),
                Enter.theValue("Test Automation").into(KEYWORDS_INPUT),
                Enter.theValue("Notes").into(NOTES_INPUT),
                Click.on(CONSENT_CHECKBOX),
                Click.on(SAVE_BUTTON)
        );
    }
}
