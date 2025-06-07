package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class InventoryPage  {
    private WebDriver driver;

    //localisador de elementos
     private By pageTitle=By.className("title");
     private By inventoryItems = By.cssSelector(".inventory_item");// Para obtener todos los productos
     private By addbolsoCard= By.id("add-to-cart-sauce-labs-backpack");
     private By cardico= By.className("shopping_cart_link");
     private By contadorCard= By.className("shopping_cart_badge");
     private  By addaddbikelight=By.id("add-to-cart-sauce-labs-bike-light");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para validar si estamos en la página de inventario
    public Boolean isAt() {
        return driver.findElement(pageTitle).getText().equals("Products");
    }
    // Método para verificar que estamos en la URL de inventario
    public boolean isInInventoryUrl() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

   //Metodo para optener  el nombre del primer producto
    private By firstProductName = By.className("inventory_item_name");
    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }
    // Método para verificar todos los productos en la página
    public  boolean checkProductsAreDisplayed(){
        List<WebElement> productos= driver.findElements(inventoryItems);
        for (WebElement producto: productos){
            // Verificamos que cada producto tenga nombre, descripción, precio y que la imagen sea visible
            By nombre = By.cssSelector(".inventory_item_name");
            By descripcion = By.cssSelector(".inventory_item_desc");
            By precio = By.cssSelector(".inventory_item_price");
            By imagen = By.cssSelector(".inventory_item_img");
            if (producto.findElement(nombre).getText().isEmpty()||
                    producto.findElement(descripcion).getText().isEmpty()||
                    producto.findElement(precio).getText().isEmpty()||
                    !producto.findElement(imagen).getText().isEmpty()){
                return  false;// Si alguno de los elementos no es válido, devolvemos false
            }
        }
        return true;// Si todos los productos son válidos, devolvemos true
    }

 public void addcardbolso(){
        driver.findElement(addbolsoCard).click();
 }
 public void addbikelight(){
     driver.findElement(addaddbikelight).click();
 }

  public  void ingresarCard(){
        driver.findElement(cardico).click();

  }
  public  String getcardItemCount()
  {
      return driver.findElement(contadorCard).getText();
  }


}



