package day10_actionClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {
    @Test
    public void test01(){
        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //  /Users/ahmetbulutluoz/Downloads/foto.png
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"
        System.out.println(System.getProperty("user.dir"));
        // projenin dosya yolunu verir
// C:\Users\Hilal Nur\IdeaProjects\com.seleniumJUnit
        System.out.println(System.getProperty("user.home"));
       // C:\Users\Hilal Nur

         /* biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            /Users/ahmetbulutluoz               /Downloads/image.jpg
            herkesin bilgisayarinda farkli      herkeste ayni
            System.getProperty("user.home")     /Downloads/image.jpg
         */
        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = "/Downloads/image.jpg";
        String dosyaYolu= dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // ayni islemi projemizin altindaki deneme.txt icin yapsak
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt
        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluherkesteAyniOlanKisim = "src/test/java/day10_actionClass_Faker_FileTestleri/deneme.txt";
        dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}