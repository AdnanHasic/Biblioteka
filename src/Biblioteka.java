import javax.swing.*;
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

        JOptionPane.showMessageDialog(null,
                "Morate izabrati datoteku spisak knjiga u narednom prozoru !",
                "Biblioteka Tuzla",
                JOptionPane.INFORMATION_MESSAGE);

        JFileChooser prozorIzbora = null;
        try {
            prozorIzbora = new JFileChooser();

            int izbor = -1;

            while (izbor != JFileChooser.APPROVE_OPTION) {
                prozorIzbora.setDialogTitle("Izaberite datoteku za citanje : ");
                prozorIzbora.setSelectedFile(null);
                izbor = prozorIzbora.showOpenDialog(null);

            }
        } catch (Exception e) {
            System.out.println("Greska prilikom ucitavanja datoteke");
        }

        File datoteka = prozorIzbora.getSelectedFile();

        Scanner ulaz = null;

        try {
            ulaz = new Scanner(new FileReader(datoteka));

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

            System.out.println("Greska prilikom ucitavanja datoteke");
        }



        int broj = 1;

        while (broj != 0) {


            novaKnjiga.ispisListe(listaKnjiga);

            String odgovor = JOptionPane.showInputDialog(null,
                    "Da li vec imate kreiran racun : DA ili NE ",
                    "Biblioteka Tuzla",
                    JOptionPane.QUESTION_MESSAGE);

            if (!new Metode().provjeraDaLiImaVecUBaziKorisnika(odgovor)) {
               KreiranjeKorisnickogRacuna.kreirajKorisnickiRacun(listaKorisnickihRacuna);
            }

            novaKnjiga.ispisListe(listaKorisnickihRacuna);

            new Metode().iznajmljivanjeKnjige(listaKnjiga, listaKorisnickihRacuna);

            novaKnjiga.ispisListe(listaKorisnickihRacuna);

            System.out.println("Za izlaz iz programa unesite broj 0 za nastavak neki drugi broj : \n");
            broj = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Za izlaz iz programa unesite broj 0 za nastavak neki drugi broj : \n",
                    "Biblioteka Tuzla",
                    JOptionPane.QUESTION_MESSAGE));
        }
        novaKnjiga.ispisListe(listaKnjiga);

        Biblioteka.unos.close();

        ulaz.close();

        JOptionPane.showMessageDialog(null,
                "Hvala sto ste koristili nase usluge !",
                "Biblioteka Tuzla",
                JOptionPane.INFORMATION_MESSAGE);
    }
}