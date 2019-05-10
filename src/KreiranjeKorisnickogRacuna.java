import javax.swing.*;
import java.util.List;

public class KreiranjeKorisnickogRacuna {

      private static int brojKorisnika = 0;

    public static KorsinickiRacun kreirajKorisnickiRacun(List<KorsinickiRacun> listaKorisnickihRacuna) {

        System.out.println("\nUkoliko zelite da iznajmite neku od navedenih knjiga koje su na stanju morate kreirati racun : ");

        String imeIprezime  = JOptionPane.showInputDialog(null,
                "Unesite ime i prezime :",
                "Biblioteka Tuzla",
                JOptionPane.QUESTION_MESSAGE);

        String brojTelefona = JOptionPane.showInputDialog(null,
                "Unesite broj telefona :",
                "Biblioteka Tuzla",
                JOptionPane.QUESTION_MESSAGE);

        String adresa = JOptionPane.showInputDialog(null,
                "Unesite adresu :",
                "Biblioteka Tuzla",
                JOptionPane.QUESTION_MESSAGE);;

        String knjiga = "-----------";

        brojKorisnika++;

        KorsinickiRacun noviKorisnik = new KorsinickiRacun(imeIprezime,brojTelefona,adresa,brojKorisnika,knjiga);

        listaKorisnickihRacuna.add(noviKorisnik);

        return noviKorisnik;

    }

}
