package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",   // Ruta donde están los .feature
        glue = "stepDefinitions",                   // Ruta donde están los Steps
        plugin = {"pretty", "html:target/cucumber-report.html"}, // Reporte HTML
        monochrome = true                           // Salida limpia en consola
)

public class TestRunner {
}