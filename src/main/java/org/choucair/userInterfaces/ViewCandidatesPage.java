package org.choucair.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ViewCandidatesPage extends PageObject {

    public static final Target ADD_USER_BUTTON = Target.the("Add button")
            .located(By.xpath("//button[normalize-space()='Add']"));

    public static final Target CANDIDATE_NAME_SEARCH = Target.the("Candidates rows")
            .located(By.cssSelector("input[placeholder=\"Type for hints...\"]"));

    public static final Target SEARCH_CANDIDATE_BUTTON = Target.the("Search button")
            .located(By.cssSelector("button.orangehrm-left-space"));

    public static final Target CANDIDATE_CHECKBOX = Target.the("User checkbox")
            .located(By.cssSelector("i.oxd-checkbox-input-icon"));

    public static final Target STATUS_CANDIDATE_LIST = Target.the("Cell status candidates")
            .locatedBy("//div[@class='oxd-table-cell oxd-padding-cell']");
}

