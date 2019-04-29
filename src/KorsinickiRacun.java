import java.util.Date;
import java.util.List;

public class KorsinickiRacun extends Korisnik {

    private int brojKorisnika = 0;
    private String knjiga;

    public KorsinickiRacun() {
    }

    public KorsinickiRacun(int brojKorisnika, String imeIprezime, String brojTelefona, String adresa, String knjiga) {
        super(imeIprezime, brojTelefona, adresa);
        this.knjiga = knjiga;
        this.brojKorisnika = brojKorisnika;
    }

    public int getBrojKorisnika() {
        return brojKorisnika;
    }

    public void setBrojKorisnika(int brojKorisnika) {
        this.brojKorisnika = brojKorisnika;
    }


    public void setDatum(Date datum) {

    }


    public String getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(String knjiga) {
        this.knjiga = knjiga;
    }


    public void kreiRajKorisnickiRacun(List<KorsinickiRacun> listaKorisnickihRacuna) {
        System.out.println("\nUkoliko zelite da iznajmite neku od navedenih knjiga koje su na stanju morate kreirati racun : ");

        System.out.println("Unesite ime i prezime :");
        String imeIprezime = Biblioteka.unos.nextLine();

        System.out.println("Unesite broj telefona : ");
        String brojTelefona = Biblioteka.unos.next();

        System.out.println("Unesite adresu : ");
        Biblioteka.unos.nextLine();

        String adresa = Biblioteka.unos.nextLine();

        String knjiga = "-----------";

        brojKorisnika++;

        KorsinickiRacun noviKorisnik = new KorsinickiRacun(brojKorisnika, imeIprezime, brojTelefona, adresa, knjiga);

        listaKorisnickihRacuna.add(noviKorisnik);

    }

    public boolean provjeraDaLiImaVecUBaziKorisnika(String odgovor) {
        if (odgovor.equalsIgnoreCase("DA")) {
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return String.format("%10s%-5s%15s%-20s%20s%-17s%15s%-11s%15s%-15S",
                "Korisnicki broj : ", brojKorisnika,
                "Izabrana knjiga : ", knjiga,
                "Ime i prezime korisnika :", imeIprezime,
                "Broj telefona : ", brojTelefona,
                "Adresa : ", adresa, "\n");
    }
}

