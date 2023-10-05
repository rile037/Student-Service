import java.util.ArrayList;
import java.util.HashMap;

public class Ispit {
    private String[] sviPredmeti = {"ETF", "PDF", "MTA", "TTA", "ENG", "INZM", "AOR","OTF","IOR","IPA"};

    public String[] getSviPredmeti() {
        return sviPredmeti;
    }

    private String[] datumiIspita = {
            "09.08.2023.",
            "10.08.2023.",
            "10.08.2023.",
            "10.08.2023.",
            "11.08.2023.",
            "13.08.2023.",
            "15.08.2023.",
            "17.08.2023.",
            "18.08.2023.",
            "18.08.2023.",
    };
    private final ArrayList<String> korisnickaListaIspita = new ArrayList<String>();
    private final HashMap<String, String> datumiSvihIspita = new HashMap<String, String>();

    public Ispit()
    {
        for(int i = 0; i < sviPredmeti.length; i++){
            String predmet = sviPredmeti[i];
            String datum = datumiIspita[i];
            datumiSvihIspita.put(predmet,datum);
        }
    }
    public HashMap<String, String> getDatumiSvihIspita(){
        return datumiSvihIspita;
    }

    public void prikaziDatumeIspita(){
        for (int i = 0; i < sviPredmeti.length; i++) {
            String ispit = sviPredmeti[i];
            String datum = datumiSvihIspita.get(ispit);

            System.out.println("---------- ISPIT ----------");
            System.out.println((i + 1) + ". " + ispit + " - " + datum + "\n");
        }
    }
    
    public void dodajIspitUKorisnickuListu(String predmet) {
        korisnickaListaIspita.add(predmet);
    }

    public ArrayList<String> getKorisnickaListaIspita() {
        return korisnickaListaIspita;
    }

}
