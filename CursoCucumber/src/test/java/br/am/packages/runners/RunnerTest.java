package br.am.packages.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        tags = "not @ignore",
        features = "src/test/resources/features",
        glue = "br.am.packages.steps"
        )
public class RunnerTest {

}


