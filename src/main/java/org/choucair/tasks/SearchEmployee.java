package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Employee;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.choucair.userInterfaces.PIMPage.*;

@AllArgsConstructor
public class SearchEmployee implements Task {

    private final List<Employee> employees;

    public static SearchEmployee byName(List<Employee> employees) {
        return instrumented(SearchEmployee.class, employees);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Employee employee = employees.get(0);
        String fullName = employee.getFirstName() + " " + employee.getLastName();

        actor.attemptsTo(
                WaitUntil.the(SEARCH_EMPLOYEE_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(fullName).into(SEARCH_EMPLOYEE_NAME_INPUT),
                Click.on(SEARCH_BUTTON)
        );
    }
}