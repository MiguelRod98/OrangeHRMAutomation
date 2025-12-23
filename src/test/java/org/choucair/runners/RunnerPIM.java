package org.choucair.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_employee_pim.feature",
        tags = "@PIM",
        glue = "org/choucair/stepDefinitions",
        plugin = {"pretty", "json:target/cucumber-report-pim.json", "html:target/cucumber-html-report-pim", "junit:target/cucumber-junit-pim.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerPIM {
}