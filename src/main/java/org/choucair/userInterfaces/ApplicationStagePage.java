package org.choucair.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ApplicationStagePage extends PageObject {

    public static final Target SUCCESS_STAGE_BUTTON = Target.the("Success stage button")
            .located(By.cssSelector("button.oxd-button--success"));

    public static final Target SUCCESS_STAGE_OFFER_JOB_BUTTON = Target.the("Success stage button")
            .located(By.xpath("//button[text()=\" Offer Job \"]"));
}
