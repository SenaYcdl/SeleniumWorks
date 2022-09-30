package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class Odev25_Iframe extends TestBaseBeforeAfter {

    /*
    Iframe Home Work
1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
2. “Our Products” butonuna basin
3. “Cameras product”i tiklayin
4. Popup mesajini yazdirin
5. “close” butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

     */


    @Test
    public void test() {
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //"Our Products" butonuna basin
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("//p[contains(text(),'Cameras')]")).click();

        //Popup mesajini yazdirin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        String popUp = driver.findElement(By.className("modal-body")).getText();
        System.out.println(popUp);

        //"close" butonuna basin
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]")).click();
        driver.switchTo().defaultContent();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("//*[text()=\"WebdriverUniversity.com (IFrame)\"]")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedLink="http://webdriveruniversity.com/index.html";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(expectedLink,actualLink);
    }
}
