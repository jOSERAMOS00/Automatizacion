package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {
        // Este método se ejecuta antes de cada escenario
        driver = DriverManager.getDriver(); // Obtiene o inicia el navegador
    }

    @After
    public void tearDown() {
        // Este método se ejecuta después de cada escenario
        DriverManager.quitDriver(); // Cierra el navegador
    }

}
