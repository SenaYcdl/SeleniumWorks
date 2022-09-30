package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Odev29_WebTables {
    /*
    Bir Class olusturun D19_WebtablesHomework
    1- “https://demoqa.com/webtables” sayfasina gidin
    2- Headers da bulunan department isimlerini yazdirin
    3- sutunun basligini yazdirin
    4- Tablodaki tum datalari yazdirin
    5- Tabloda kac cell (data) oldugunu yazdirin
    6- Tablodaki satir sayisini yazdirin
    7- Tablodaki sutun sayisini yazdirin
    8- Tablodaki 3.kolonu yazdirin
    9- Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    10 -Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() throws Exception {
        //1
        driver.get("https://demoqa.com/webtables");
        //2
        List<WebElement> depNames = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][6]"));
        depNames.stream().forEach(t -> System.out.println(t.getText()));
        //3
        List<WebElement> headerNames = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        headerNames.stream().forEach(t -> System.out.print(t.getText() + " "));
        System.out.println("\n \n");
        //4
        List<WebElement> tbodyNames = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        tbodyNames.stream().forEach(t -> System.out.print(t.getText()));
        System.out.println("\n \n");
        //5
        List<WebElement> tbodyNamesCells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Tablodaki Data Cell Sayisi : " + tbodyNamesCells.size());
        System.out.println("\n \n");
        //6
        List<WebElement> tbodyRows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi : " + tbodyRows.size());
        System.out.println("\n \n");
        //7
        List<WebElement> Column = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("Tablodaki Sutun Sayisi : " + Column.size());
        System.out.println("\n \n");
        //8
        List<WebElement> thirdRow = driver.findElements(By.xpath("//div[@class='rt-tr-group'][2]"));
        thirdRow.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("\n \n");
        //9
        List<WebElement> kierraSalary = driver.findElements(By.xpath("//div[@class='rt-td'][5]"));
        System.out.println(kierraSalary.get(2).getText());
        System.out.println("\n \n");
        //10
        pageMethod(2, 4);
    }

    private void pageMethod(int row, int column) {
        WebElement specificData = driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][" + (column - 1) + "])[" + (row - 1) + "]"));
        System.out.println("Actual Data  : " + specificData.getText());
        System.out.println("\n \n");
    }
}