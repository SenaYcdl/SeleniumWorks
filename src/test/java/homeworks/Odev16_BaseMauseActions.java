package homeworks;

import com.google.common.cache.Weigher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class Odev16_BaseMauseActions extends TestBaseBeforeAfter {

    //sendKeys ( ): Öğeye bir dizi anahtar gönderir
    //■ keyDown ( ): Klavyede tuşa basma işlemi gerçekleştirir
    //■ keyUp ( ): Klavyede tuşu serbest bırakma işlemi gerçekleştirir

    //Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak
    //samsung A71 yazdirin ve Enter’a basarak arama
    //yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test(){

        driver.get("https://www.amazon.com");
        WebElement box=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.moveToElement(box).click();
        actions.keyDown(Keys.SHIFT);
        actions.sendKeys("samsung A71").keyUp(Keys.SHIFT).contextClick().build().perform();




    }

}
