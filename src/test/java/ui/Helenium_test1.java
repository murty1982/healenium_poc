package ui;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helenium_test1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver deligate = new ChromeDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(deligate);

        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Gmail']")).click();
        System.out.println("Able to click on Gmail link");
    }
}
