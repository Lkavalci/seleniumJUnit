package day11_seleniumWaits_webTables;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        // normalde cookiesleri yadirdi. fakat düzenlemek icin :
        int siraNo=1;

        for (Cookie eachCookie : cookiesSet) {
            System.out.println(siraNo+"------"+eachCookie);
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi = 5;
        int actualcookiSayisi= cookiesSet.size();
        Assert.assertTrue(actualcookiSayisi>expectedMinCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookiValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookiValue,actualCookieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie eklenecekCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(eklenecekCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        siraNo=1;
        cookiesSet = driver.manage().getCookies();
        String enSevdigimCookieValue = "";
        for (Cookie eachCookie : cookiesSet) {
            System.out.println(siraNo+"--------"+eachCookie);
            if (eachCookie.getName().equals("en sevdigim cookie")){
                enSevdigimCookieValue = eachCookie.getValue();
            }
            siraNo++;
        }
        expectedCookiValue="cikolatali";
        Assert.assertEquals(expectedCookiValue,actualCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().getCookieNamed("skin"); //sildik simdide test edelim bakalim silmis mi?

        siraNo=1;
        cookiesSet=driver.manage().getCookies();
        for (Cookie eachCookie : cookiesSet) {
            System.out.println(siraNo+"---"+eachCookie);
            siraNo++;
        }
     /*

        //7-a- ismi skin olan cookie’yi silin ve silindigini test edin ve silindiğini yani yok olduğunu ispatlayın
        driver.manage().deleteCookieNamed("skin");
        siraNo=1;
        cookiesSet = driver.manage().getCookies();
        String flag = "skin isminde bir cookie yok";
        for (Cookie eachCookie : cookiesSet
        ) {
            System.out.println(siraNo+"------" + eachCookie);
            if (eachCookie.getName().equals("skin")){
                flag="skin isminde cookie bulundu";
            }
            siraNo++;
        }
        Assert.assertTrue(flag.equals("skin isminde bir cookie yok"));
     */
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertEquals(cookiesSet.size(),0);
    }
}