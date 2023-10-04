import java.util.*;

// Interface LoginHandler za pristup Studentskom Servisu

interface loginHandler{
    static boolean login(List<Student> spisakStudenata, String korisnickoIme, int lozinka){
        for (Student student : spisakStudenata) {
            if (student.getKorisnickoIme().equals(korisnickoIme) && student.getLozinka() == lozinka) {
                return true;
            }
        }
        return false;
    }
}

interface AdminInterface{
    void dodajStudenta(Student.Admin admin, Student student);
    void obrisiStudenta(Student.Admin admin, Student student);
}

class Student implements loginHandler{

    // Zasticene promenljive
    private String korisnickoIme;
    private int lozinka;

    // Privatne promenljive
    private String ime, imeRoditelja, prezime, datumRodjenja, smer;
    private int godinaUpisa;

    // Lista studenata dostupna bez instanciranja objekta
    private static List<Student> spisakStudenata = new ArrayList<>();

    // Poruke prilikom prijave korisnika
    private final String porukaLoginTrue = "Uspesna prijava na studentski servis.";
    private final String porukaLoginFalse = "Greska, proverite vase podatke.";


    // Konstruktor
    public Student(String korisnickoIme, int lozinka, String ime, String imeRoditelja, String prezime, String datumRodjenja, String smer, int godinaUpisa) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.imeRoditelja = imeRoditelja;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.smer = smer;
        this.godinaUpisa = godinaUpisa;
        spisakStudenata.add(this);
    }

    public static List<Student> getSpisakStudenata(){
        return spisakStudenata;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getLozinka() {
        return lozinka;
    }

    public void setLozinka(int lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }
    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }
    static class Admin implements AdminInterface{

        private String korisnickoIme;
        private String lozinka;
        private boolean admin;

        public Admin(){
            this.korisnickoIme = "admin";
            this.lozinka = "admin";
            this.admin = true;
        }

        public String whoami(){
            return this.korisnickoIme;
        }

        @Override
        public void dodajStudenta(Admin admin, Student student) {
            if(!admin.admin){
                System.out.println("Nemate ovlascenja.");
            }else{
                Student.getSpisakStudenata().add(student);
                System.out.println(student.getIme() + " je dodat u spisak.");
            }
        }
        @Override
        public void obrisiStudenta(Admin admin, Student student) {
            if(!admin.admin)
            {
                System.out.println("Nemate ovlascenja.");
            }
            else{
                Student.getSpisakStudenata().add(student);
                System.out.println(student.getIme() + " je obrisan sa spiska.");
            }
        }
    }

    class Predmet extends Student{
        private double prosek;
        String[] predmeti = {"ETF", "PDF", "MTA", "TTA", "ENG", "INZM", "AOR","OTF","IOR","IPA"};

        // To Do za funkciju upisiavanja ocena
        //HashMap<String, Integer> predmetiOcene = new HashMap<String, Integer>();


        public Predmet(double prosek, String[] predmeti){
            super(korisnickoIme, lozinka, ime, imeRoditelja, prezime, datumRodjenja, smer, godinaUpisa);
            this.prosek = prosek;
            //this.predmeti = predmeti;

            // algoritam za upis ocene
//            for(int i = 0; i < predmeti.length; i++){
//                predmetiOcene.put(predmeti[i],10);
//            }


        }

        public void setProsek(double prosek) {
            this.prosek = prosek;
        }
    }
}