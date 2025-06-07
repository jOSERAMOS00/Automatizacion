package stepDefinitions;

import config.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.InventoryPage;
import page.LoginPage;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver(); // Obtiene el WebDriver desde la clase DriverManager
    LoginPage loginPage;

    @Given("que estoy en la página de login de SauceDemo")
    public void que_estoy_en_la_pagina_de_login() {
        driver.get("https://www.saucedemo.com/");  // Abre la página
        loginPage = new LoginPage(driver);         // Inicializa la página de login
    }

    @When("ingreso usuario {string} y contraseña {string}")
    public void ingreso_usuario_y_contraseña(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);      // Usa el método login de LoginPage
    }

    @Then("debería ingresar al inventario")
    public void deberia_ingresar_al_inventario() {
        InventoryPage inventoryPage= new InventoryPage(driver);
        Assert.assertTrue("No estas en la página de inventario",inventoryPage.isAt()); // Verifica que se redirige correctamente
    }

    @Then("debería ver un mensaje de error")
    public void deberia_ver_un_mensaje_de_error() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface")); // Verifica mensaje de error
    }

}
