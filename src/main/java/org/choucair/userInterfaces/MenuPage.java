package org.choucair.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage extends PageObject {

    public static final Target RECRUITMENT_MENU_ITEM = Target.the("Item menu Recruitment")
            .located(By.xpath("//span[normalize-space()='Recruitment']"));
}
