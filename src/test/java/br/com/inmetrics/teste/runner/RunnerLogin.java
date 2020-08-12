package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/Login.feature",
    plugin = {"pretty", "html:target/cucumber-report",
	   "json:target/cucumber-report/cucumber.json"},
    monochrome = true,
    dryRun = false,
    glue = ""
    )

public class RunnerLogin {

}
