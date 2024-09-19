package org.choucair.userInterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LoginPage extends PageObject {

    public static final Target USERNAME_INPUT = Target.the("Input username")
            .located(By.cssSelector("input[name='username']"));

    public static final Target PASSWORD_INPUT = Target.the("Input Password")
            .located(By.cssSelector("input[name='password']"));

    public static final Target LOGIN_BUTTON = Target.the("Button login")
            .located(By.cssSelector("button.orangehrm-login-button"));
}