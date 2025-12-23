package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.choucair.models.Employee;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.choucair.userInterfaces.PIMPage.*;

@AllArgsConstructor
public class FillEmployeeForm implements Task {

    private final List<Employee> employees;

    public static FillEmployeeForm withData(List<Employee> employees) {
        return instrumented(FillEmployeeForm.class, employees);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Employee employee = employees.get(0);
        
        // Generar número random para apellido y username
        Random random = new Random();
        int randomNumber = random.nextInt(999) + 1;
        String lastNameWithNumber = employee.getLastName() + randomNumber;
        String usernameWithNumber = employee.getFirstName().toLowerCase() + randomNumber;

        actor.attemptsTo(
                WaitUntil.the(FIRST_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(employee.getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(employee.getMiddleName()).into(MIDDLE_NAME_INPUT),
                Enter.theValue(lastNameWithNumber).into(LAST_NAME_INPUT)
        );

        // Activar Create Login Details si está especificado
        if ("Yes".equals(employee.getCreateLoginDetails())) {
            actor.attemptsTo(
                    Click.on(CREATE_LOGIN_TOGGLE),
                    WaitUntil.the(USERNAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(usernameWithNumber).into(USERNAME_INPUT),
                    Enter.theValue(employee.getUserPassword()).into(PASSWORD_INPUT),
                    Enter.theValue(employee.getConfirmPassword()).into(CONFIRM_PASSWORD_INPUT)
            );
        }

        actor.attemptsTo(
                Click.on(SAVE_BUTTON)
        );

        // Guardar los datos generados para uso posterior
        employee.setLastName(lastNameWithNumber);
        employee.setUsername(usernameWithNumber);
    }
}