package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev21_FileExist extends TestBaseBeforeAfter {

    /*
    1. Tests packagenin altina bir class oluşturun : C05_UploadFile
2. https://the-internet.herokuapp.com/upload adresine gidelim
3. chooseFile butonuna basalim
4. Yuklemek istediginiz dosyayi secelim.
5. Upload butonuna basalim.
6. “File Uploaded!” textinin goruntulendigini test edelim
     */


    @Test
    public void test() {


        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        WebElement file = driver.findElement(By.id("file-upload"));


        //4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\Oğuz\\OneDrive\\Desktop\\New Text Document.txt";
        file.sendKeys(dosyaYolu);


        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@class='button']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='example'] h3")).isDisplayed());


    }

}
