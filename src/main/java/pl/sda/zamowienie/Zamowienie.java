package pl.sda.zamowienie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Zamowienie {
    private List<Pozycja> pozycje = new ArrayList<Pozycja>();

    public void dodajPozycje(Pozycja p) {
        if (p != null) {
            boolean czyZnaleziono = false;
            for (Pozycja pozycja : pozycje) {
                if(pozycja.getNazwaTowaru().equalsIgnoreCase(p.getNazwaTowaru())
                && pozycja.getCena() ==  p.getCena()){
                    pozycja.setIleSztuk(pozycja.getIleSztuk() + p.getIleSztuk());
                    czyZnaleziono = true;
                    break;
                }
            }
            if (!czyZnaleziono){
                pozycje.add(p);
            }
        }

    }

    public double obliczWartosc() {
        double suma = 0;
        for (Pozycja pozycja : pozycje) {
            suma = suma + pozycja.obliczWartosc();
        }
        return suma;
    }

    public double obliczWartoscZRabatem(){
        double suma = 0;
        for (Pozycja pozycja : pozycje) {
            suma = suma + pozycja.obliczWartoscZRabatem();
        }
        return suma;
    }

    public String toString() {
        String out = "Zamówienie: \n";
        for (Pozycja pozycja : pozycje) {
            out = out + pozycja.toString() + "\n";

        }


        return out + "Razem: " + String.format("%.2f", obliczWartosc()) + " zł \n"
                + "Uwzględniono rabat w wysokości: " + String.format("%.2f", obliczWartosc()-obliczWartoscZRabatem()) + " zł \n"
                + "Kwota do zapłaty: " + String.format("%.2f", obliczWartoscZRabatem()) + " zł \n"  ;
    }
    public void usunPozycje(int indeks){
        try {
            pozycje.remove(indeks);
        } catch (IndexOutOfBoundsException e){
            System.out.println("nie ma pozycji o podanym indeksie: " + indeks);
        }

    }

    public void edytujPozycje(int indeks, String nazwaTowaru, int ilość, double cena){
        try {
            Pozycja edytowanaPozycja = pozycje.get(indeks);
            edytowanaPozycja.setNazwaTowaru(nazwaTowaru);
            edytowanaPozycja.setIleSztuk(ilość);
            edytowanaPozycja.setCena(cena);
        } catch (IndexOutOfBoundsException e){
            System.out.println("nie ma pozycji o podanym indeksie: " + indeks);
        }
    }
}
