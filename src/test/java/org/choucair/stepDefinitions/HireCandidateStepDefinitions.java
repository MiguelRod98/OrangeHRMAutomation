package org.choucair.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.choucair.models.Candidate;
import org.choucair.questions.AnswerSuccessfulRecruitment;
import org.choucair.tasks.*;
import org.choucair.userInterfaces.LoginPage;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HireCandidateStepDefinitions {

    @Before
    public void setStage() {

        setTheStage(new OnlineCast());
        theActor("candidate");
    }

    @Given("the recruiter is on the login page")
    public void theRecruiterIsOnTheLoginPage() {

        theActorInTheSpotlight().attemptsTo(

                Open.browserOn().the(LoginPage.class)
        );
    }

    @When("he logs in with valid credentials")
    public void heLogsInWithValidCredentials() {

        theActorInTheSpotlight().attemptsTo(

                Login.withCredentials()
        );
    }

    @When("he navigates to the Recruitment item menu")
    public void heNavigatesToTheRecruitmentSection() {

        theActorInTheSpotlight().attemptsTo(

                GoToRecruitment.recruitmentItemMenu()
        );
    }

    @When("he adds a new candidate with valid details")
    public void heAddsANewCandidateWithValidDetails() {

        Candidate candidate = Candidate.builder()
                .firstName("Anderson")
                .middleName("Andrés")
                .lastName("Alonso")
                .email("alonso@gmail.com")
                .phone("3023618215")
                .build();

        theActorInTheSpotlight().attemptsTo(

                GoToAddCandidate.addCandidateOption(),
                FillFormAddCandidate.withTheData(candidate)
        );
    }

    @When("he finishes the complete the hiring process")
    public void heFinishesTheCompleteTheHiringProcess() {

        theActorInTheSpotlight().attemptsTo(

                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes(),
                GoToStageNextStep.successOption(),
                FillScheduleInterview.addDataInterview(),
                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes(),
                GoToStageNextStep.successOfferJobOption(),
                FillNotesCandidate.addNotes(),
                GoToStageNextStep.successOption(),
                FillNotesCandidate.addNotes()
        );
    }

    @Then("he should see the candidate as hired")
    public void heShouldSeeTheCandidateAsHired() {

        theActorInTheSpotlight().attemptsTo(

                GoToRecruitment.recruitmentItemMenu(),
                SearchCandidate.byName(),
                Ensure.that("Hiring success", AnswerSuccessfulRecruitment.byValue()).isEqualTo(true)
        );

    }
}
