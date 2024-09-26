package org.choucair.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.choucair.models.Candidate;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.choucair.userInterfaces.LoginPage.*;

@AllArgsConstructor
public class Login implements Task {

    private final List<Candidate> candidate;

    public static Login withCredentials(List<Candidate> candidate) {

        return instrumented(Login.class, candidate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue(candidate.get(0).getUsername()).into(USERNAME_INPUT),
                Enter.theValue(candidate.get(0).getPassword()).into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );
    }
}
