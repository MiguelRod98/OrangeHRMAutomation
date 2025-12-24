package org.choucair.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "org/choucair/stepDefinitions",
        plugin = {"pretty", "json:target/cucumber-report-parallel.json", "html:target/cucumber-html-report-parallel", "junit:target/cucumber-junit-parallel.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ParallelRunner {
}