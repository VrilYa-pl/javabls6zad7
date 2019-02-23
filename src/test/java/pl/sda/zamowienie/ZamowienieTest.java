package pl.sda.zamowienie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ZamowienieTest {
    @Test
    public void testTworzeniaBezArgumentow(){
        //given
        Zamowienie zamowienie = new Zamowienie();
        //when
        List<Pozycja> listaPozycji = new ArrayList<Pozycja>();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 3, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        listaPozycji.add(pozycja);
        listaPozycji.add(pozycja2);
        listaPozycji.add(pozycja3);
        zamowienie.setPozycje(listaPozycji);
        //then
        assertEquals(3, zamowienie.getPozycje().size());

    }

    @Test
    public void testTworzeniaZArgumentami(){
        //given
        List<Pozycja> listaPozycji = new ArrayList<Pozycja>();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 3, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        listaPozycji.add(pozycja);
        listaPozycji.add(pozycja2);
        listaPozycji.add(pozycja3);
        //when
        Zamowienie zamowienie = new Zamowienie(listaPozycji);
        //then
        assertEquals(3, zamowienie.getPozycje().size());
    }

    @Test
    public void testDodawaniaZamowienia(){

        //given
        Zamowienie zamowienie2 = new Zamowienie();

        //when
        Pozycja pozycja2 = new Pozycja("woda", 5, 2);
        zamowienie2.dodajPozycje(pozycja2);

        //then
        assertEquals(1, zamowienie2.getPozycje().size());
    }

    @Test
    public void testDodawaniaZamowieniaZNullem(){
        //given
        Zamowienie zamowienie2 = new Zamowienie();
        //when
        zamowienie2.dodajPozycje(null);
        //then
        assertEquals(0, zamowienie2.getPozycje().size());
    }

    @Test
    public void testSumyZamowienia(){

        //given
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
        //when

        double sumaZamowienia = zamowienieSuma.obliczWartosc();

        //then
        assertEquals(Double.valueOf(pozycja.obliczWartosc() + pozycja2.obliczWartosc() + pozycja3.obliczWartosc())
                , Double.valueOf(sumaZamowienia));
    }
    @Test
    public void testWydruku(){
        //given
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
        //then
        System.out.println(zamowienieSuma);
        assertTrue(zamowienieSuma.toString().contains("Razem: "));
        assertTrue(zamowienieSuma.toString().contains("Zamówienie: "));
        assertTrue(zamowienieSuma.toString().contains(String.format("%.2f" ,zamowienieSuma.obliczWartosc())));
    }

    @Test
    public void testUsuwania(){
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
    //when
        zamowienieSuma.usunPozycje(1);
    //then
    assertEquals(2, zamowienieSuma.getPozycje().size());
        System.out.println(zamowienieSuma.getPozycje().get(0));
        System.out.println(zamowienieSuma.getPozycje().get(1));
}
    @Test
    public void testUsuwaniaPozaIndeksem(){
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        zamowienieSuma.dodajPozycje(pozycja);
        //when
        zamowienieSuma.usunPozycje(1);
        //then
        assertEquals(1, zamowienieSuma.getPozycje().size());
    }

    @Test
    public void testEdycjiZamowienia(){
        //given
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
        //when
        zamowienieSuma.edytujPozycje(1, "woda", 3, 1);
        //then
        Pozycja pozycjaPobrana = zamowienieSuma.getPozycje().get(1);
        assertEquals("woda", pozycjaPobrana.getNazwaTowaru());
        assertEquals(3, pozycjaPobrana.getIleSztuk());
        assertEquals(Double.valueOf(1), Double.valueOf(pozycjaPobrana.getCena()));
        System.out.println(zamowienieSuma);
    }

    @Test
    public void testDodajPozycje(){
        //given
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        Pozycja pozycja4 = new Pozycja("mleko", 5, 2.50);
        Pozycja pozycja5 = new Pozycja("mleko", 10, 5.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
        zamowienieSuma.dodajPozycje(pozycja4);
        zamowienieSuma.dodajPozycje(pozycja5);
        //then
        assertEquals(4, zamowienieSuma.getPozycje().size());
        Pozycja pozycjaPobrana = zamowienieSuma.getPozycje().get(0);
        assertEquals("mleko", pozycjaPobrana.getNazwaTowaru());
        assertEquals(7, pozycjaPobrana.getIleSztuk());
        Pozycja pozycjaPobrana2 = zamowienieSuma.getPozycje().get(3);
        assertEquals("mleko", pozycjaPobrana2.getNazwaTowaru());
        assertEquals(10, pozycjaPobrana2.getIleSztuk());

        System.out.println(zamowienieSuma);
    }

    @Test
    public void testSumyZamowieniaZRabatem(){
        //given
        Zamowienie zamowienieSuma = new Zamowienie();
        Pozycja pozycja = new Pozycja("mleko", 2, 2.50);
        Pozycja pozycja2 = new Pozycja("cukier", 5, 4.50);
        Pozycja pozycja3 = new Pozycja("maslo", 4, 2.00);
        zamowienieSuma.dodajPozycje(pozycja);
        zamowienieSuma.dodajPozycje(pozycja2);
        zamowienieSuma.dodajPozycje(pozycja3);
        //when
        double sumaZamowienia = zamowienieSuma.obliczWartoscZRabatem();
        //then
        assertEquals(Double.valueOf(pozycja.obliczWartoscZRabatem() + pozycja2.obliczWartoscZRabatem() + pozycja3.obliczWartoscZRabatem())
                , Double.valueOf(sumaZamowienia));
    }

}