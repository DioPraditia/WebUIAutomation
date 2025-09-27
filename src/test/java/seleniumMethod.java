import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumMethod {

    @Test
    public void BrowserMethodTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();

        System.out.println("Title pada halaman web:" + title);
        System.out.println("URL saat ini pada halaman web:" + currentURL);
    }

    @Test
    public void navigationMethodTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.navigate().refresh();
        driver.navigate().to("https://jayjay.co/");
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Title pada halaman web:" + title);
        System.out.println("URL saat ini pada halaman web:" + currentURL);
    }

    @Test
    public void ImplicitWaitTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).getText());
        Thread.sleep(2000);

    }

    @Test
    public void ExplicitWaitTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]")));
        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).getText());

        Thread.sleep(1000);
    }

    @Test
    public void FluentWaitTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]")));

        assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).getText());

        Thread.sleep(1000);
    }
}
