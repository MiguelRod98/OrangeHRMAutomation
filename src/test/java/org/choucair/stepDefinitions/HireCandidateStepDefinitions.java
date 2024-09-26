package org.choucair.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.choucair.models.Candidate;
import org.choucair.questions.AnswerSuccessfulRecruitment;
import org.choucair.tasks.*;
import org.choucair.userInterfaces.LoginPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HireCandidateStepDefinitions {

    @Before
    public void setStage() {

        setTheStage(new OnlineCast());
        theActor("Candidate");
    }

    @DataTableType
    public Candidate candidateEntry(Map<String, String> entry) {

        return new Candidate(
                entry.get("username"),
                entry.get("password"),
                entry.get("firstName"),
                entry.get("middleName"),
                entry.get("lastName"),
                entry.get("vacancy"),
                entry.get("email"),
                entry.get("phone"),
                entry.get("cv"),
                entry.get("keywords"),
                entry.get("notes"),
                entry.get("tittleInterview"),
                entry.get("interviewer")
        );
    }

    @Given("the recruiter is on the login page")
    public void theRecruiterIsOnTheLoginPage() {

        theActorInTheSpotlight().attemptsTo(

                Open.browserOn().the(LoginPage.class)
        );
    }

    @When("he logs in with valid credentials")
    public void heLogsInWithValidCredentials(List<Candidate> candidate) {

        theActorInTheSpotlight().attemptsTo(

                Login.withCredentials(candidate)
        );
    }

    @When("he navigates to the Recruitment item menu")
    public void heNavigatesToTheRecruitmentSection() {

        theActorInTheSpotlight().attemptsTo(

                GoToRecruitment.recruitmentItemMenu()
        );
    }

    @When("he adds a new candidate with valid details")
    public void heAddsANewCandidateWithValidDetails(List<Candidate> candidate) {

        theActorInTheSpotlight().attemptsTo(

                GoToAddCandidate.addCandidateOption(),
                FillFormAddCandidate.withTheData(candidate)
        );
    }

    @When("he finishes the complete the hiring process")
    public void heFinishesTheCompleteTheHiringProcess(List<Candidate> candidate) {

        theActorInTheSpotlight().attemptsTo(

                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes(candidate),
                GoToStageNextStep.successOption(),
                FillScheduleInterview.addDataInterview(candidate),
                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes(candidate),
                GoToStageNextStep.successOfferJobOption(),
                FillNotesCandidate.addNotes(candidate),
                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes(candidate)
        );
    }

    @Then("he should see the candidate as hired")
    public void heShouldSeeTheCandidateAsHired(List<Candidate> candidate) {

        theActorInTheSpotlight().attemptsTo(

                GoToRecruitment.recruitmentItemMenu(),
                SearchCandidate.byName(candidate),
                Ensure.that("Hiring success", AnswerSuccessfulRecruitment.byValue(candidate)).isEqualTo(true)
        );

    }
}
