import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void adminMenu() {
        LocalDateTime vremeSada = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
        String vreme = vremeSada.format(format);
        Student.Admin admin = new Student.Admin();
        System.out.println("Dobrodosli admin, vreme sesije: " + vreme + "\n");
        System.out.println("- Spisak svih komandi: ");
        for(String komanda : admin.getSpisakKomandi()){
            System.out.print(komanda + ", ");
        }
        System.out.println("\n");
    }

    public static void studentMenu() {
        System.out.println("\n1. Prijavi ispit");
        System.out.println("2. Pogledaj sve datume ispita");
        System.out.println("3. Pogledaj prijavljene ispite");
        System.out.println("0. Izlaz");
    }

    public static void main(String[] args) {
        Student.Admin admin = new Student.Admin();
        Student student = new Student("rile037", 123, "Nikola", "Radisa", "Rilak", "14.08.1999.", "NRT", 2018);
        Scanner scanner = new Scanner(System.in);
        List<Student> listaStudenata = Student.getSpisakStudenata();
        Ispit ispit = new Ispit();
        boolean prijavljen = false;
        boolean isAdmin = false; //

        System.out.println("Dobrodosli, molimo Vas da se prijavite");

        while (!prijavljen) {
            System.out.println("Korisnicko ime: ");
            String korisnickoIme = scanner.next();
            System.out.println("Lozinka: ");
            String lozinkaAdmin = scanner.next();

            if (korisnickoIme.equals("admin") && lozinkaAdmin.equals("admin")) {
                isAdmin = true; // Postavljamo isAdmin na true za admina
                break;
            } else {
                int lozinka = Integer.parseInt(lozinkaAdmin);
                boolean rezultatPrijave = loginHandler.login(listaStudenata, korisnickoIme, lozinka);
                if (rezultatPrijave) {
                    System.out.println("Uspesna prijava");
                    prijavljen = true;
                    break;
                } else {
                    System.out.println("Pogresni podaci, pokusajte ponovo.");
                }
            }
        }

        // Nakon uspešnog logovanja, ide provera za admina
        if (isAdmin) {
            adminMenu();
            while (true) {
                System.out.println("Unos: ");
                String komanda = scanner.next();
                switch (komanda) {
                    case "whoami" -> {
                        System.out.println("- admin");
                    }
                    case "dodajstudenta" -> {
                        System.out.println("- dodajStudenta");
                    }
                    case "izbrisistudenta" ->{
                        System.out.println("- izbrisiStudenta");
                    }
                    case "izlistajstudente" -> {
                        for(Student x : Student.getSpisakStudenata()){
                            student.prikaziStudenta(x);
                        }
                    }
                    case "exit" -> {
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Pogresan izbor.");
                }
            }
        } else {
            // U suprotnom prikazujemo studenta i njegov interfejs
            System.out.println("Dobrodosli, " + student.getIme());
            while (true) {
                studentMenu(); // Pozivamo studentMenu u kojem je spisak opcija
                HashMap<String, String> datumiSvihIspita = ispit.getDatumiSvihIspita();
                int izbor = scanner.nextInt();
                scanner.nextLine();
                switch (izbor) {
                    case 1 -> {
                        ispit.prikaziDatumeIspita();
                        // Omogućavanje korisniku da dodaje ispite u svoju listu
                        while (true) {
                            System.out.print("Unesite redni broj ispita koji želite dodati (ili '0' za izlaz): ");
                            int unos = scanner.nextInt();
                            if (unos == 0) {
                                break;
                            }
                            try {
                                String[] sviPredmeti = ispit.getSviPredmeti();
                                if (unos >= 1 && unos <= sviPredmeti.length) {
                                    String predmet = sviPredmeti[unos - 1];
                                    ispit.dodajIspitUKorisnickuListu(predmet);
                                    System.out.println(predmet + " je dodat u vašu listu ispita.");
                                } else {
                                    System.out.println("Uneli ste nevažeći redni broj.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Uneli ste neispravan format. Molimo vas unesite redni broj.");
                            }
                        }
                    }

                    case 2 -> {
                        ispit.prikaziDatumeIspita();
                    }

                    case 3 -> {
                        ArrayList<String> korisnickaListaIspita = ispit.getKorisnickaListaIspita();
                        if(korisnickaListaIspita.isEmpty()){
                            System.out.println("\nNiste prijavili nijedan ispit");
                        }
                        else{
                            System.out.println("\nVaša lista ispita:");
                            for (int i = 0; i < korisnickaListaIspita.size(); i++) {
                                String x = korisnickaListaIspita.get(i);
                                String datum = datumiSvihIspita.get(x);
                                System.out.println((i + 1) + ". " + x + " - " + datum);
                            }
                        }
                    }
                    case 0 -> {
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Pogresan izbor.");
                }
            }
        }
    }
}
