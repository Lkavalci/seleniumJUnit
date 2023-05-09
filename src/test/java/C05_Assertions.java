import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

    WebDriver driver;
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        // 2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        //    asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
            }

            @Test
    public void test01() {
                //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
                mahserin4Atlisi();
                String expectedUrl="https://www.bestbuy.com/";
                String actualUrl= driver.getCurrentUrl();

                Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02(){
        //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unExpectedIcerik ="Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));
    }

    @Test
    public void test03(){
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
    }
}
/*


    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

 */