import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteka {

    public static Scanner unos = new Scanner(System.in);

    public static void main(String[] args) {

        Knjiga novaKnjiga = null;
        KorsinickiRacun noviKorisnik = new KorsinickiRacun();
        List<Knjiga> listaKnjiga = new ArrayList<>();
        List<KorsinickiRacun> listaKorisnickihRacuna = new ArrayList<>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/spisakKnjiga.txt");
            Scanner ulaz = new Scanner(fis);

            while (ulaz.hasNextLine()) {
                int redniBroj = Integer.parseInt(ulaz.nextLine());
                String imeAutora = ulaz.nextLine();
                String nazivKnjige = ulaz.nextLine();
                String naStanju = ulaz.nextLine();
                String datumIzdavanjaKnjige = ulaz.nextLine();
                novaKnjiga = new Knjiga(redniBroj, imeAutora, nazivKnjige, naStanju, datumIzdavanjaKnjige);
                listaKnjiga.add(novaKnjiga);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int broj = 1;
        while (broj != 0) {
            novaKnjiga.ispisListe(listaKnjiga);
            System.out.println("Da li vec imate kreiran racun : DA ili NE ");
            String odgovor = Biblioteka.unos.nextLine();
            if (!noviKorisnik.provjeraDaLiImaVecUBaziKorisnika(odgovor)) {
                noviKorisnik.kreiRajKorisnickiRacun(listaKorisnickihRacuna);
            }
            novaKnjiga.ispisListe(listaKorisnickihRacuna);
            novaKnjiga.iznajmljivanjeKnjige(listaKnjiga, listaKorisnickihRacuna);
            novaKnjiga.ispisListe(listaKorisnickihRacuna);
            System.out.println("Za izlaz iz programa unesite broj 0 za nastavak neki drugi broj : \n");
            broj = unos.nextInt();
            unos.nextLine();
        }
        Biblioteka.unos.close();
    }
}