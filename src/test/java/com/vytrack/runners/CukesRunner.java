package com.vytrack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/vytrack/features/Login.feature",
        glue = "com/vytrack/step_definitions",
        tags = "@driver or sales",
        dryRun = true
)
public class CukesRunner {
}

