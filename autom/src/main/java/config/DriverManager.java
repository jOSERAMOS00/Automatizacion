package config;
 import  org.openqa.selenium.WebDriver;//mporta la interfaz WebDriver, que es la base de Selenium para manejar navegadores.
 import  org.openqa.selenium.chrome.ChromeDriver;// Importa la clase ChromeDriver, que nos permite automatizar Chrome.


public class DriverManager {
     private  static  WebDriver driver;// Declara una variable driver de tipo WebDriver, que será estática (es decir, una sola instancia para toda la aplicación).

    public  static  WebDriver getDriver(){
        if (driver==null){
            driver= new ChromeDriver();
            driver.manage().window().maximize();
                }
        return  driver;
    }

     public  static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver= null;
        }
     }
}
