package day10_actionClass_Faker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KlavyeActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim ve cıkarsa cookies'i kabul edelim
        driver.get("https://www.facebook.com");
      //  driver.findElement(By.xpath("//button[@*='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@* = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.xpath("//*[@id='u_3_b_DT']"));
        actions.click(isimKutusu)
                .sendKeys("Hilal Nur")
                .sendKeys(Keys.TAB)
                .sendKeys("KAVALCI")
                .sendKeys(Keys.TAB)
                .sendKeys("falanfesmekan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("falanfesmekan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Sivas58")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Nisan")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
     //4- Kaydol tusuna basalim
                .sendKeys(Keys.ENTER).perform();


        Thread.sleep(2000);
    }
}