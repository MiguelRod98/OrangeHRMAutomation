package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.LoginPage.*;

@AllArgsConstructor
public class Login implements Task {

    public static Login withCredentials() {

        return instrumented(Login.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue("Admin").into(USERNAME_INPUT),
                Enter.theValue("admin123").into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );
    }
}
