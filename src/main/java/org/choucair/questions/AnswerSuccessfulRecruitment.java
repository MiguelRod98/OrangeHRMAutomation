package org.choucair.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.choucair.userInterfaces.ViewCandidatesPage.*;

@AllArgsConstructor
public class AnswerSuccessfulRecruitment implements Question<Boolean> {

    public static AnswerSuccessfulRecruitment byValue() {

        return new AnswerSuccessfulRecruitment();
    }

    public static String getDatesCandidateList(Actor actor, int index) {

        return STATUS_CANDIDATE_LIST.resolveAllFor(actor).get(index).getText();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String expectedStatusText = "Hired";
        String expectedCandidateText = "Anderson";
        String expectedManagerText = "a";
        String expectedDateApplicationText = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        String expectedVacancyText = "Payroll";

        String valueVacancyText = getDatesCandidateList(actor, 1);
        String valueCandidateText = getDatesCandidateList(actor, 2);
        String valueManagerText = getDatesCandidateList(actor, 3);
        String valueDateApplicationText = getDatesCandidateList(actor, 4);
        String valueStatusText = getDatesCandidateList(actor, 5);

        return valueStatusText.equals(expectedStatusText) &&
                valueCandidateText.contains(expectedCandidateText) &&
                valueManagerText.contains(expectedManagerText) &&
                valueDateApplicationText.contains(expectedDateApplicationText) &&
                valueVacancyText.contains(expectedVacancyText);
    }
}
