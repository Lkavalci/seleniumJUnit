package day13_ExcelOtomasyonu_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumsayfaScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Nutella aratalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonucların Nutella icerdigini test edelim
        WebElement sonucElementi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String actualSonucYazisi=sonucElementi.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // rapora eklenmek uzere, tum sayfanın ekran goruntusunu alalim

        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfaResim);

        //------------------------------- yukardaki gibi ekran goruntusu almak ıcın uzun uzun yazmaktansa
        // once bir method olustururuz ve bunu heryerde kullanabiliriz.
        // reusableMethod kullanarak aşagıdaki gibi yapabiliriz. ve boylece kısa yoldan ekran goruntusu alabiliriz

         ReusableMethods.tumSayfaFotografCek(driver);
    }
}