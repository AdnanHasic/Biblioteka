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




    @Override
    public String toString() {
        return String.format("%10s%3d%12s%23s%20s%25s%15S%5S%25s%32s", "R.b. knjige =", redniBrojKnjige,
                "Autor =", autorKnjige,
                "Naziv knjige =", nazivKnjige,
                "Na stanju =", naStanju,
                "Datum izdavanja knjige=", datum);

    }

}
