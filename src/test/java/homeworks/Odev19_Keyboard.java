package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev19_Keyboard extends TestBaseBeforeAfter {

    /*
    Bir Class olusturalim KeyboardActions2
https://html.com/tags/iframe/ sayfasina gidelim  3- video’yu gorecek kadar asagi inin
videoyu izlemek icin Play tusuna basin
videoyu calistirdiginizi test edin

     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://html.com/tags/iframe/");
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        List<WebElement> iFrameList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iFrameList.get(0));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        Thread.sleep(5000);


        //videoyu calistirdiginizi test edin
        WebElement videoStart = driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay' and @style='display: none;']"));
        Assert.assertTrue(videoStart.isEnabled());



    }
}
