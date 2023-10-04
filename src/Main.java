import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void adminMenu() {
        // Dodajte funkcionalnosti za admin meni ovde
    }

    public static void studentMenu() {
        System.out.println("Dobrodosli studente");
        // Dodajte funkcionalnosti za student meni ovde
    }

    public static void main(String[] args) {
        Student.Admin admin = new Student.Admin();
        Student student = new Student("rile037", 123, "Nikola", "Radisa", "Rilak", "14.08.1999.", "NRT", 2018);
        Scanner scanner = new Scanner(System.in);
        List<Student> listaStudenata = Student.getSpisakStudenata();
        boolean prijavljen = false;
        boolean isAdmin = false; // Dodali smo isAdmin promenljivu

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

        // Nakon uspešnog logovanja, prikažite odgovarajući meni
        if (isAdmin) {
            LocalDateTime vremeSada = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
            String vreme = vremeSada.format(format);
            System.out.println("Dobrodosli admin");
            System.out.println(vreme);
            // Ako je admin prijavljen, prikaži admin meni
            while (true) {
                adminMenu(); // Pozivamo adminMenu metodu za admina
                // Dodajte funkcionalnosti za admin meni ovde
                System.out.print("Unos: ");
                String komanda = scanner.next();
                switch (komanda) {
                    case "whoami" -> {
                        System.out.println("- admin");
                    }
                    // Dodajte opcije za admin meni
                    case "exit" -> {
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Pogresan izbor.");
                }
            }
        } else {
            // Ako je student prijavljen, prikaži student meni
            while (true) {
                studentMenu(); // Pozivamo studentMenu metodu za studenta
                // Dodajte funkcionalnosti za student meni ovde

                int izbor = scanner.nextInt();

                switch (izbor) {
                    // Dodajte opcije za student meni
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
