package homeworks;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev23_Faker extends TestBaseBeforeAfter {

    /*

    1. "https://facebook.com" Adresine gidin
2. “create new account” butonuna basin
3. “firstName” giris kutusuna bir isim yazin
4. “surname” giris kutusuna bir soyisim yazin
5. “email” giris kutusuna bir email yazin
6. “email” onay kutusuna emaili tekrar yazin
7. Bir sifre girin
8. Tarih icin gun secin
9. Tarih icin ay secin
10. Tarih icin yil secin
11. Cinsiyeti secin
12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13. Sayfayi kapatin
     */

    @Test
    public void test() throws InterruptedException {


        // 1. "https://facebook.com" Adresine gidin
        driver.get("https://www.facebook.com");

        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).sendKeys(Keys.ENTER);

        //3. “firstName” giris kutusuna bir isim yazin
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        Faker faker=new Faker();
        WebElement name=driver.findElement(By.name("firstname"));
        String mail=faker.internet().emailAddress();
        actions.click(name).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(mail).
                sendKeys(Keys.TAB).
                sendKeys(mail).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("2").sendKeys(Keys.TAB).sendKeys("December").
                sendKeys(Keys.TAB).sendKeys("1998").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //11. Cinsiyeti secin
        driver.findElement(By.xpath("//*[text()='Female']")).click();
        Thread.sleep(200);

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='Female']")).isSelected());

        //13. Sayfayi kapatin
        driver.quit();


    }
}
