package org.choucair.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PIMPage extends PageObject {

    public static final Target ADD_EMPLOYEE_BUTTON = Target.the("Add Employee button")
            .located(By.xpath("//a[normalize-space()='Add Employee']"));

    public static final Target FIRST_NAME_INPUT = Target.the("First name input")
            .located(By.name("firstName"));

    public static final Target MIDDLE_NAME_INPUT = Target.the("Middle name input")
            .located(By.name("middleName"));

    public static final Target LAST_NAME_INPUT = Target.the("Last name input")
            .located(By.name("lastName"));

    public static final Target EMPLOYEE_ID_INPUT = Target.the("Employee ID input")
            .located(By.xpath("//label[text()='Employee Id']/../..//input"));

    public static final Target CREATE_LOGIN_TOGGLE = Target.the("Create Login Details toggle")
            .located(By.xpath("//span[contains(@class,'oxd-switch-input')]"));

    public static final Target USERNAME_INPUT = Target.the("Username input")
            .located(By.xpath("(//input[@autocomplete='off'])[1]"));

    public static final Target PASSWORD_INPUT = Target.the("Password input")
            .located(By.xpath("(//input[@type='password'])[1]"));

    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Confirm Password input")
            .located(By.xpath("(//input[@type='password'])[2]"));

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target EMPLOYEE_LIST_MENU = Target.the("Employee List menu")
            .located(By.xpath("//a[normalize-space()='Employee List']"));

    public static final Target SEARCH_EMPLOYEE_NAME_INPUT = Target.the("Search employee name input")
            .located(By.xpath("//label[text()='Employee Name']/../..//input"));

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target EMPLOYEE_RECORD = Target.the("Employee record in table")
            .located(By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]"));

    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .located(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
}