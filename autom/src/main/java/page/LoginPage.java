package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private  WebDriver driver;
    //localisador de elementos
    private By usernameField= By.id ( "user-name");// Campo de usuario
    private By passwordField= By.id("password") ;// Campo de contraseña
    private By loginButton = By.id("login-button"); // Botón de login
    private By errorMessage = By.cssSelector("[data-test='error']");

    //Constructor
     public LoginPage(WebDriver driver){
         this.driver=driver;
     }

     //Método para hacer login
    public void login(String username, String password){
         driver.findElement(usernameField).clear();
         driver.findElement(usernameField).sendKeys(username);
         driver.findElement(passwordField).clear();
         driver.findElement(passwordField).sendKeys(password);
         driver.findElement(loginButton).click();
    }

    // Obtener mensaje de error
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

}