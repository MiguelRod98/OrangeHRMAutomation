package org.choucair.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/hire_candidate.feature",
        tags = "@Hiring",
        glue = "org/choucair/stepDefinitions",
        plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-html-report", "junit:target/cucumber-junit.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerRecruitment {
}
