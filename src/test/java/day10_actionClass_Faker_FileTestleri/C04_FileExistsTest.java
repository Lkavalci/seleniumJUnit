package day10_actionClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest {

    @Test
    public void test01(){
        // com.seleniumJUnit projesi icerisinde
        // deneme.txt dosyasinin varoldugunu test edin

        String dosyaYolu = "src/test/java/day10_actionClass_Faker_FileTestleri/deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
