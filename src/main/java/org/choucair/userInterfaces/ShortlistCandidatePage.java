package org.choucair.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShortlistCandidatePage extends PageObject {

    public static final Target NOTES_TEXTAREA = Target.the("Notes shortlist textarea")
            .located(By.cssSelector("textarea.oxd-textarea"));

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .located(By.cssSelector("button[type='submit']"));
}
