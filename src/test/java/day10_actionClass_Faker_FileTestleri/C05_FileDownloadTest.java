package day10_actionClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. image.jpg dosyasını indirelim
        WebElement fotoElementi= driver.findElement(By.xpath("//*[@id='content']/div/a[7]"));
        fotoElementi.click();
        Thread.sleep(5000);


        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // Dosyayi Downloads (karşıdan yüklenenler) klasorune indirecek
        String dosyaYolu="C:/Users/Hilal Nur/Downloads/image.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png" ..gibi...
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

    }
}