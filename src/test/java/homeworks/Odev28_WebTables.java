package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Odev28_WebTables extends TestBaseBeforeAfter {

    /*
    WebTables class’ini kullanin.
1. Bir metod oluşturun : printData(int row, int column);
a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
hücredeki(cell) veriyi yazdırmalıdır.
2. Baska bir Test metodu oluşturun: printDataTest( );
a. Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */


    @Test
    public void test1() {

        login();
        printData();

    }




    public void printData() {

        int row = 3;
        int column = 5;
        WebElement cell = driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        System.out.println("Sutun ve satirdaki text : " + cell.getText());

        WebElement text=driver.findElement(By.xpath("//*[text()='USA']"));
        Assert.assertTrue(text.getText().contains("USA"));



    }


    public void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");


        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }

}
