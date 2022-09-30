package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev12Iframe extends TestBaseBeforeAfter {

    /*
    ● Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız

     */

    @Test
    public void test() throws InterruptedException {


        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");


        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> list=new ArrayList<>(driver.findElements(By.tagName("iframe")));
        System.out.println(list.size());


        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(list.get(0));
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        Thread.sleep(2000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        driver.navigate().refresh();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


        driver.quit();

    }





}
