package org.choucair.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.choucair.models.Employee;
import org.choucair.questions.EmployeeExists;
import org.choucair.tasks.*;
import org.choucair.userInterfaces.LoginPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CreateEmployeePIMStepDefinitions {

    private List<Employee> currentEmployees;

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
        theActor("HR Administrator");
    }

    @DataTableType
    public Employee employeeEntry(Map<String, String> entry) {
        return new Employee(
                entry.get("username"),
                entry.get("password"),
                entry.get("firstName"),
                entry.get("middleName"),
                entry.get("lastName"),
                entry.get("employeeId"),
                entry.get("createLoginDetails"),
                entry.get("userPassword"),
                entry.get("confirmPassword"),
                entry.get("status")
        );
    }

    @Given("the HR administrator is on the login page")
    public void theHRAdministratorIsOnTheLoginPage() {
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().the(LoginPage.class)
        );
    }

    @When("he logs in with admin credentials")
    public void heLogsInWithAdminCredentials(List<Employee> employees) {
        this.currentEmployees = employees;
        Employee emp = employees.get(0);
        List<org.choucair.models.Candidate> candidates = List.of(
                new org.choucair.models.Candidate(emp.getUsername(), emp.getPassword(), 
                        null, null, null, null, null, null, null, null, null, null, null)
        );
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(candidates)
        );
    }

    @When("he navigates to the PIM module")
    public void heNavigatesToThePIMModule() {
        theActorInTheSpotlight().attemptsTo(
                GoToPIM.module()
        );
    }

    @When("he adds a new employee with login details")
    public void heAddsANewEmployeeWithLoginDetails(List<Employee> employees) {
        this.currentEmployees = employees;
        theActorInTheSpotlight().attemptsTo(
                GoToAddEmployee.option(),
                FillEmployeeForm.withData(employees)
        );
    }

    @When("he navigates to employee list")
    public void heNavigatesToEmployeeList() {
        theActorInTheSpotlight().attemptsTo(
                GoToEmployeeList.option()
        );
    }

    @When("he searches for the created employee")
    public void heSearchesForTheCreatedEmployee() {
        theActorInTheSpotlight().attemptsTo(
                SearchEmployee.byName(currentEmployees)
        );
    }

    @Then("he should see the employee exists in the list")
    public void heShouldSeeTheEmployeeExistsInTheList(List<Employee> employees) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("Employee exists in list", EmployeeExists.inList(currentEmployees)).isEqualTo(true)
        );
    }
}