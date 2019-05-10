import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Metode {

    public boolean provjeraDaLiImaVecUBaziKorisnika(String odgovor) {
        if (odgovor.equalsIgnoreCase("DA")) {
            return true;
        }
        return false;

    }


    public boolean provjeraLogovanja(int korisnickiBroj, List<KorsinickiRacun> listaKorisnickihRacun) {
        for (int i = 0; i < listaKorisnickihRacun.size(); i++) {
            if (korisnickiBroj == listaKorisnickihRacun.get(i).getBrojKorisnika()) {
                return true;
            }
        }
        return false;
    }


    public void iznajmljivanjeKnjige(List<Knjiga> listaKnjiga, List<KorsinickiRacun> listaKorisnickihRacuna) {

        System.out.println("Za log unesite Vas korisnicki broj : ");
        int korisnickiBroj = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Za log unesite Vas korisnicki broj : ",
                "Biblioteka Tuzla",
                JOptionPane.QUESTION_MESSAGE));

        while (!provjeraLogovanja(korisnickiBroj, listaKorisnickihRacuna)) {

            korisnickiBroj = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Unijeli ste pogresan korisnicki broj pokusajte ponovo : ",
                    "Biblioteka Tuzla",
                    JOptionPane.QUESTION_MESSAGE));
        }
        System.out.println("Unesite broj za knjigu : ");

        int brojZaKnjigu = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Unesite broj za knjigu : ",
                "Biblioteka Tuzla",
                JOptionPane.QUESTION_MESSAGE));

        while (!provjeraBrojaKnjigeNaListi(brojZaKnjigu, listaKnjiga)) {

            brojZaKnjigu = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Knjigu koju ste trazili nemamo na stanju pod tim brojem unseite drugi broj knjige :",
                    "Biblioteka Tuzla",
                    JOptionPane.QUESTION_MESSAGE));
        }


        while (!provjeraDaLiJeNaStanjuKnjiga(brojZaKnjigu, listaKnjiga)) {
            brojZaKnjigu = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Unesite broj za knjigu : ",
                    "Biblioteka Tuzla",
                    JOptionPane.QUESTION_MESSAGE));
        }

        for (int i = 0; i < listaKorisnickihRacuna.size(); i++) {
            if (korisnickiBroj == listaKorisnickihRacuna.get(i).getBrojKorisnika()) {
                listaKorisnickihRacuna.get(i).setKnjiga(listaKnjiga.get(brojZaKnjigu).getNazivKnjige());
                promijeniUIznajmljena(listaKnjiga, brojZaKnjigu);
            }
        }
    }

    public static void promijeniUIznajmljena(List<Knjiga> listaKnjiga, int brojaZaknjigu) {
        for (int i = 0; i < listaKnjiga.size(); i++) {
            if (brojaZaknjigu == listaKnjiga.get(i).getRedniBrojKnjige()) {
                listaKnjiga.get(i).setNaStanju("NE");
                listaKnjiga.get(i).setDatum(new Date().toString());
            }
        }
    }

    public static boolean provjeraDaLiJeNaStanjuKnjiga(int brojZaKnjigu, List<Knjiga> listaKnjiga) {
        for (int i = 0; i < listaKnjiga.size(); i++) {
            if (brojZaKnjigu == listaKnjiga.get(i).getRedniBrojKnjige()) {
                if (listaKnjiga.get(i).getNaStanju().equalsIgnoreCase("NE")) {
                    System.out.println("Zao nam je knjigu nemamo na stanju,izaberite drugu knjigu !");
                    return false;
                }

            }
        }
        return true;
    }


    public static boolean provjeraBrojaKnjigeNaListi(int brojKnjige, List<Knjiga> listaKnjiga) {
        if (brojKnjige >= listaKnjiga.size()) {
            return false;
        }
        return true;
    }

}
