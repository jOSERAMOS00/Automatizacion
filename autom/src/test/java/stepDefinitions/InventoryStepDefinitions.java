package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page.InventoryPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import page.LoginPage;
import config.DriverManager;

import static org.junit.Assert.*;

public class InventoryStepDefinitions {
    private WebDriver driver;
    private InventoryPage inventoryPage;


    @Given("El usuario ha iniciado sesión correctamente")
    public void  el_usuario_ha_iniciado_sesión_correctamente(){
         driver = DriverManager.getDriver();
          driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(driver);
        assertTrue("El usuario no fue dirigido a la página de inventario", inventoryPage.isAt());
    }

    // Suponiendo que ya tienes una página de login que te dirige al inventario
    @When("^El usuario navega a la página de inventario$")
    public void el_usuario_navega_a_la_pagina_de_inventario() {
        inventoryPage = new InventoryPage(driver);
        // Asegúrate de estar en la página correcta
        assertTrue(inventoryPage.isAt());
    }

    @Then("^Los productos deben aparecer con su nombre, descripción, imagen y precio$")
    public void los_productos_deben_aparecer_con_su_nombre_descripcion_imagen_y_precio() {
        // Verificamos que los productos están correctamente mostrados
        assertTrue(inventoryPage.checkProductsAreDisplayed());
    }

    @When("El usuario agrega la mochila al carrito")
    public  void el_usuario_agrega_la_mochila_al_carrito(){
        inventoryPage.addcardbolso();
    }
    @When("El usuario agrega la 2 productos al carrito")
    public  void el_usuario_agrega_la_2_productos_al_carrito(){
        inventoryPage.addcardbolso();
        inventoryPage.addbikelight();
    }

    @Then("El ícono del carrito debe mostrar el número {string}")
    public  void el_ícono_del_carrito_debe_mostrar_el_número ( String cantidadEsperada) {
        assertEquals(cantidadEsperada, inventoryPage.getcardItemCount());

    }
}
