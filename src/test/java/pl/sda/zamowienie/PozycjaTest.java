package pl.sda.zamowienie;

import org.junit.Test;

import static org.junit.Assert.*;

public class PozycjaTest {
    @Test
    public void testTworzeniePozycji() {
        //given
        Pozycja pozycjaTest = new Pozycja();
        //when
        pozycjaTest.setNazwaTowaru("chleb");
        pozycjaTest.setIleSztuk(2);
        pozycjaTest.setCena(5.20);
        //then
        assertEquals("chleb", pozycjaTest.getNazwaTowaru());
        assertEquals(2, pozycjaTest.getIleSztuk());
        assertEquals(Double.valueOf(5.20), Double.valueOf(pozycjaTest.getCena()));
    }
    @Test
    public void testTworzeniaPozycjizKonstruktorem(){
        Pozycja pozycja1 = new Pozycja("chlebZytni", 3, 6.20);

        assertEquals("chlebZytni", pozycja1.getNazwaTowaru());
        assertEquals(3, pozycja1.getIleSztuk());
        assertEquals(Double.valueOf(6.20), Double.valueOf(pozycja1.getCena()));

    }

    @Test
    public void testObliczWartosc(){
        //given
        Pozycja pozycja2 = new Pozycja("chlebZytni", 3, 6.20);
        //when
        double v = pozycja2.obliczWartosc();
        //then
        assertEquals(Double.valueOf(18.60), Double.valueOf(v));

    }

    @Test
    public void testObliczWartoscPoZmianie(){
        //given
        Pozycja pozycja2 = new Pozycja("chlebZytni", 3, 6.20);
        //when
        pozycja2.setIleSztuk(5);
        double v = pozycja2.obliczWartosc();
        //then
        assertEquals(Double.valueOf(31), Double.valueOf(v));
    }

    @Test
    public void testOutput(){
        //given
        Pozycja pozycja3 = new Pozycja("kiełbasa", 5, 2.50);
        //when

        //then
        System.out.println(pozycja3);
    }

    @Test
    public void testPonizej5(){
        Pozycja pozycja3 = new Pozycja("kiełbasa", 4, 2.50);

        assertEquals(Double.valueOf(10), Double.valueOf(pozycja3.obliczWartoscZRabatem()));
    }
    @Test
    public void testOd5do10(){
        Pozycja pozycja3 = new Pozycja("kiełbasa", 8, 2.50);

        assertEquals(Double.valueOf(19), Double.valueOf(pozycja3.obliczWartoscZRabatem()));
    }
    @Test
    public void testOd11do20(){
        Pozycja pozycja3 = new Pozycja("kiełbasa", 14, 2.50);
        double wartoscZRabatem = pozycja3.obliczWartoscZRabatem();
        assertEquals(Double.valueOf(31.5), Double.valueOf(wartoscZRabatem));
    }

    @Test
    public void testPowyzej20(){
        Pozycja pozycja3 = new Pozycja("kiełbasa", 30, 2.50);
        double wartoscZRabatem = pozycja3.obliczWartoscZRabatem();
        assertEquals(Double.valueOf(63.75), Double.valueOf(wartoscZRabatem));
    }
}