package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\FeatureFile",glue ="org.execution",snippets = SnippetType.CAMELCASE,
dryRun = false)


public class TestRunnerClass {

}
