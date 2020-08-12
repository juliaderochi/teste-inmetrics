package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/Funcionario.feature",
    plugin = {"pretty", "html:target/cucumber-report",
	   "json:target/cucumber-report/cucumber.json"},
    tags = {"@editarFuncionario"},
    monochrome = true,
    dryRun = false,
    glue = ""
    )

public class RunnerFuncionario {

}
