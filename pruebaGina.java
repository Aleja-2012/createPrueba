package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;


public class pruebaGina{
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://pre.jelpit.com/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void primerEjercicio() throws InterruptedException {
        String title = driver.getTitle();

        WebElement imgLogin = driver.findElement(By.xpath("//span[@class='icon-icono_usuario']"));
        imgLogin.click();
        Thread.sleep(5000);


        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='loginInMail']"));
        txtEmail.sendKeys("martha.oyuela.morales@segurosbolivar.com");
        Thread.sleep(1000);
        WebElement txtPassword = driver.findElement(By.id("loginInPass"));
        txtPassword.sendKeys( "Mora2023les*");
        Thread.sleep(1000);

        WebElement btnLogin = driver.findElement(By.id("loginUser"));
        btnLogin.submit();

        //WebElement lblName = driver.findElement(By.xpath("//*[@id='menu-site']/app-menu/div/div/div[1]/div[2]/ul/li[2]/a/span[2]"));

        //WebElement nombre = driver.findElement(By.linkText("Hola Martha"));
        //System.out.println (nombre);
        //String validarUser = driver.findElement(By.xpath("//*[@id='menu-site']/app-menu/div/div/div[1]/div[2]/ul/li[2]/a/span[2]")).getText();
        //String validarUser = driver.findElement(By.xpath("//span[@class='icon-icono_usuario']//following-sibling::span[@class='txt_link']")).getText();
        //System.out.println (validarUser);
        Thread.sleep(3000);
        //Assert.assertEquals(validarUser,"Hola Martha");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='icon-icono_usuario']//following-sibling::span[@class='txt_link']")).getText(),"Hola Martha");
    }
}

