import java.util.Date;
import java.util.List;

public class Knjiga {

    private String nazivKnjige;
    private String autorKnjige;
    private int redniBrojKnjige;
    private String naStanju;
    private String datum;

    public Knjiga() {
    }

    public Knjiga(int redniBrojKnjige, String autorKnjige, String nazivKnjige, String naStanju, String datum) {
        this.nazivKnjige = nazivKnjige;
        this.autorKnjige = autorKnjige;
        this.redniBrojKnjige = redniBrojKnjige;
        this.naStanju = naStanju;
        this.datum = datum;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getAutorKnjige() {
        return autorKnjige;
    }

    public void setAutorKnjige(String autorKnjige) {
        this.autorKnjige = autorKnjige;
    }

    public int getRedniBrojKnjige() {
        return redniBrojKnjige;
    }

    public void setRedniBrojKnjige(int redniBrojKnjige) {
        this.redniBrojKnjige = redniBrojKnjige;
    }

    public String getNaStanju() {
        return naStanju;
    }

    public void setNaStanju(String naStanju) {
        this.naStanju = naStanju;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }


    public void ispisListe(List listaKlaseKnjiga) {
        for (int i = 0; i < listaKlaseKnjiga.size(); i++) {
            System.out.println(listaKlaseKnjiga.get(i));
        }
        System.out.println("\n");
    }


    static void iznajmljivanjeKnjige(List<Knjiga> listaKnjiga, List<KorsinickiRacun> listaKorisnickihRacuna) {

        System.out.println("Za log unesite Vas korisnicki broj : ");
        int korisnickiBroj = Biblioteka.unos.nextInt();

        while (!provjeraLogovanja(korisnickiBroj, listaKorisnickihRacuna)) {
            System.out.println("Unijeli ste pogresan korisnicki broj pokusajte ponovo : ");
            korisnickiBroj = Biblioteka.unos.nextInt();
        }
        System.out.println("Unesite broj za knjigu : ");
        int brojZaKnjigu = Biblioteka.unos.nextInt();

        while (!provjeraBrojaKnjigeNaListi(brojZaKnjigu, listaKnjiga)) {
            System.out.println("Knjigu koju ste trazili nemamo na stanju pod tim brojem unseite drugi broj knjige :");
            brojZaKnjigu = Biblioteka.unos.nextInt();
        }


        while (!provjeraDaLiJeNaStanjuKnjiga(brojZaKnjigu, listaKnjiga)) {
            brojZaKnjigu = Biblioteka.unos.nextInt();
        }

        for (int i = 0; i < listaKorisnickihRacuna.size(); i++) {
            if (korisnickiBroj == listaKorisnickihRacuna.get(i).getBrojKorisnika()) {
                listaKorisnickihRacuna.get(i).setKnjiga(listaKnjiga.get(brojZaKnjigu).getNazivKnjige());
                promijeniUIznajmljena(listaKnjiga, brojZaKnjigu);
            }
        }
    }

    public static boolean provjeraBrojaKnjigeNaListi(int brojKnjige, List<Knjiga> listaKnjiga) {
        if (brojKnjige >= listaKnjiga.size()) {
            return false;
        }
        return true;
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


    public static boolean provjeraLogovanja(int korisnickiBroj, List<KorsinickiRacun> listaKorisnickihRacun) {
        for (int i = 0; i < listaKorisnickihRacun.size(); i++) {
            if (korisnickiBroj == listaKorisnickihRacun.get(i).getBrojKorisnika()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("%10s%3d%12s%23s%20s%25s%15S%5S%25s%32s", "R.b. knjige =", redniBrojKnjige,
                "Autor =", autorKnjige,
                "Naziv knjige =", nazivKnjige,
                "Na stanju =", naStanju,
                "Datum izdavanja knjige=", datum);

    }

}
