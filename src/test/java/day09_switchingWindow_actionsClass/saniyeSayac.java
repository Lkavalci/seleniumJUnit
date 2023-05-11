package day09_switchingWindow_actionsClass;

import org.junit.Test;

import java.time.LocalTime;

public class saniyeSayac {
    @Test
    public  void  test01(){

        int x =3;
        LocalTime baslangic= LocalTime.now();
        int basSaniye=baslangic.getSecond();
        int saniyeKontrol =123;

        int bitisSaniyesi= basSaniye+x >60 ? basSaniye+x-60 : basSaniye+x;

        while ( bitisSaniyesi != saniyeKontrol){
            saniyeKontrol = LocalTime.now().getSecond();
        }
            System.out.println("baslangic saniyesi : " + basSaniye);
            System.out.println("saniye Kontrol : "+ saniyeKontrol);


    }
}
