package homeworks;

public class Odev4_Checkbox {
    /*

    1. Bir class oluşturun : CheckBoxTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın

         */


    //   c.,d. Checkbox1,Checkbox2 seçili değilse onay kutusunu tıklayın
    //Aynı soruyu Liste atayıp yapmak için:
    //List<WebElement> checkBoxLarim=driver.findElements(By.xpath("//*[@type='checkbox']"));
      // checkBoxLarim.stream().filter(t ->!t.isSelected()).forEach(WebElement::click);//Method Reference
    // checkBoxLarim.stream().filter(t ->!t.isSelected()).forEach(t->t.click()); //Lambda Expession
}
