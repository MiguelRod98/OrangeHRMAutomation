package org.choucair.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\hire_candidate.feature",
        tags = "@Hiring",
        glue = "org/choucair/stepDefinitions",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerTags {
}
