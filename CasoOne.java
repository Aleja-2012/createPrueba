package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import java.util.List;


public class CasoOne {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Especifica la cantidad de tiempo que el controlador debe esperar al buscar un elemento si no está presente de inmediato.

        driver.get("https://pre.jelpit.com/");
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void loginScuccess() throws InterruptedException{
        String title = driver.getTitle();
        Assert.assertEquals(title, "Servicios para el hogar y tu familia | Jelpit");
        Thread.sleep(2000);

        WebElement botonIngresar = driver.findElement(By.linkText("Ingresar"));
        botonIngresar.click();

        WebElement usuario = driver.findElement(By.id("loginInMail"));
        usuario.sendKeys("alejandra.tamayo.qa@gmail.com");
        Thread.sleep(1000);

        WebElement pass = driver.findElement(By.id("loginInPass"));
        pass.sendKeys("Prueba12*/");
        Thread.sleep(1000);

        WebElement ingresar = driver.findElement(By.id("loginUser"));
        /// prueba
        ingresar.submit();
        Thread.sleep(6000);

        WebElement linkBienvenida = driver.findElement(By.linkText("Hola Alejandra"));
        String bienvenida = linkBienvenida.getText();
        Assert.assertEquals(bienvenida, "Hola Alejandra");
        System.out.println(bienvenida);

    }
}
