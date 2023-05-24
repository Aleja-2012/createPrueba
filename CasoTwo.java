package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class CasoTwo {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Especifica la cantidad de tiempo que el controlador debe esperar al buscar un elemento si no está presente de inmediato.

        driver.get("https://pre.jelpit.com/");

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void ValidateDocumentType() throws InterruptedException{

        WebElement botonIngresar = driver.findElement(By.linkText("Ingresar"));
        botonIngresar.click();
        Thread.sleep(5000);

        WebElement crearCuenta = driver.findElement(By.id("noRegistered"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", crearCuenta);

        Thread.sleep(1000);

        WebElement name = driver.findElement(By.id("nameRegister"));
        name.sendKeys("Martha");

        WebElement lastname = driver.findElement(By.id("lastNameRegister"));
        lastname.sendKeys("Oyuela");

        WebElement email = driver.findElement(By.id("mailRegister"));
        email.sendKeys("pruebita897@gmail.com");

        WebElement pass = driver.findElement(By.id("passRegister"));
        pass.sendKeys("Bolivar2027*");

        WebElement confPass = driver.findElement(By.id("confirmPassRegister"));
        confPass.sendKeys("Bolivar2027*");


        WebElement registrarCuenta = driver.findElement(By.id("register"));
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", registrarCuenta);

        Thread.sleep(5000);
        List <WebElement> listaDocumentos = driver.findElements(By.xpath("//mat-select[@formcontrolname='document_type']"));

        List<String> lista = new ArrayList<String>();
        // Agregar elementos a la lista
        lista.add("Cédula de Ciudadanía");
        lista.add("Cédula de Extranjería");
        lista.add("Pasaporte");

        boolean equals = true;
        for (int i = 0; i < listaDocumentos.size(); i++) {
            if (!listaDocumentos.get(i).getText().equals(lista.get(i))){
                equals = false;
                System.out.println("La lista de tipos de documentos no coincide en orden y tamaño con la esperada");
            }
            // System.out.println(listaDocumentos.get(i).getText()+",");
            //System.out.println("...................................");
            //System.out.println(lista.get(i)+",");

        }
        Assert.assertTrue(equals, "La lista de tipos de documentos no coincide en orden y tamaño con la esperada");


    }


}
