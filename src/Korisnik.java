public class Korisnik {

    public String imeIprezime;
    public String brojTelefona;
    public String adresa;

    public Korisnik() {
    }

    public Korisnik(String imeIprezime, String brojTelefona, String adresa) {
        this.imeIprezime = imeIprezime;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
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

    @Override
    public String toString() {
        return "Korisnik{" +
                "imeIprezime='" + imeIprezime + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
