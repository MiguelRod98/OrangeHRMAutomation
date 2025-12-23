package org.choucair.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Employee;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.choucair.userInterfaces.PIMPage.EMPLOYEE_RECORD;

@AllArgsConstructor
public class EmployeeExists implements Question<Boolean> {

    private final List<Employee> employees;

    public static EmployeeExists inList(List<Employee> employees) {
        return new EmployeeExists(employees);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(EMPLOYEE_RECORD, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(EMPLOYEE_RECORD)
            );
            
            Employee employee = employees.get(0);
            String actualRecord = Text.of(EMPLOYEE_RECORD).answeredBy(actor);
            
            return actualRecord.contains(employee.getFirstName()) && 
                   actualRecord.contains(employee.getLastName());
        } catch (Exception e) {
            return false;
        }
    }
}