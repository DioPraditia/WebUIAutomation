import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Selenium {

    @Test
    public void helloJayjay() throws InterruptedException {
        //inisialisasi browser driver
        WebDriver driver = WebDriverManager.chromedriver().create();

        //navigasi url
        driver.get("https://jayjay.co/");

        //get element attribute
        String text = driver.findElement(By.className("inner-content")).getText();

        //assertion / pengecekan
        assertEquals("Kursus", text);
    }
}
