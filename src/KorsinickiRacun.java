import java.util.Date;
import java.util.List;

public class KorsinickiRacun {


    private String imeIprezime;
    private String brojTelefona;
    private String adresa;
    private int brojKorisnika = 0;
    private String knjiga;

    public KorsinickiRacun() {
    }


    public KorsinickiRacun(String imeIprezime, String brojTelefona, String adresa, int brojKorisnika, String knjiga) {
        this.imeIprezime = imeIprezime;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
        this.brojKorisnika = brojKorisnika;
        this.knjiga = knjiga;
    }

    public String getImeIprezime() {
        return imeIprezime;
    }

    public void setImeIprezime(String imeIprezime) {
        this.imeIprezime = imeIprezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrojKorisnika() {
        return brojKorisnika;
    }

    public void setBrojKorisnika(int brojKorisnika) {
        this.brojKorisnika = brojKorisnika;
    }

    public String getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(String knjiga) {
        this.knjiga = knjiga;
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

