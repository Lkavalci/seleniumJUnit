package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
           Bu class icerisinde 3 test calistiralim
           1- google anasayfaya gidip, url'in google icerdigini test edin
           2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
           3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.
        Junit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

            --> Diyelim ki bir test methodu üzerinde calısıyorsunuz ve o methodun
            toplu calıstırılmalarda kullanılmasını ıstemiyorsunuz bu durumda
        @Ignore kullanabilirsiniz. (yani görmezden gel:) )
     */


    WebDriver driver;
    @Test
    public void googleTest(){
        // 1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik="google";
        String actualUrl=driver.getCurrentUrl();

        if ( actualUrl.contains(expectedIcerik)) {
            System.out.println("Google Testi : PASSED");
            } else {
            System.out.println("Url google icermiyor, Google Testi : FAILED");
        }
    driver.close();
    }
    @Test
    public void wiseTest() {
    mahserin4Atlisi();
    driver.get("https://wisequarter.com");
    String expectedIcerik = "wisequarter";
    String actualUrl = driver.getCurrentUrl();

        if ( actualUrl.contains(expectedIcerik)) {
            System.out.println("Wise Testi : PASSED");
        }else {
            System.out.println("Url Wisequarter icermiyor Wise Testi : FAILED");
        }

        driver.close();
    }
    @Test
    public void amazonTest() {
        mahserin4Atlisi();
    driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogoElementi.isDisplayed()) {
            System.out.println("Amozon Testi PASSED");
        } else {
            System.out.println("Amazon logosu gorunmuyor, Amazon Testi : FAILED");
        }
        driver.close();
    }
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));


    }

}
