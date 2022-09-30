package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev24_Actions extends TestBaseBeforeAfter {
    //Ödev 1

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2- Hover over Me First" kutusunun ustune gelin
    //Link 1" e tiklayin
    //Popup mesajini yazdirin
    //Popup'i tamam diyerek kapatin
    //"Click and hold" kutusuna basili tutun
    //7-"Click and hold" kutusunda cikan yaziyi yazdirin
    //8- "Double click me" butonunu cift tiklayin

    @Test
    public void test() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOver).perform();
        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[contains(text(),'Link 1')])[1]")).click();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //"Click and hold" kutusuna basili tutun
        WebElement clickAndHoldBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldBox).perform();
        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldBox.getText());
        //8- "Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.tagName("h2"));
        actions.doubleClick().perform();
    }
}