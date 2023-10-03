import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void adminMenu() {
        System.out.println("Dobrodosli admin");
        // Dodajte funkcionalnosti za admin meni ovde
    }

    public static void studentMenu(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dobrodosli studente");
        while(true){
            System.out.println(student.getIme() + ", dobrodosli na studentski servis.");
            System.out.println("\n- Izaberite opciju: ");
            System.out.println("1. Pogledaj predmete");

            int izbor = scanner.nextInt();

            switch (izbor) {
                case 1 -> System.out.println("Predmeti:");
                case 0 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Pogresan izbor.");
            }

        }
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
                adminMenu();
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
            // Ako je admin prijavljen, prikaži admin meni
            while (true) {
                adminMenu(); // Pozivamo adminMenu metodu za admina
                // Dodajte funkcionalnosti za admin meni ovde

                int izbor = scanner.nextInt();

                switch (izbor) {
                    // Dodajte opcije za admin meni
                    case 0 -> {
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Pogresan izbor.");
                }
            }
        } else {
            // Ako je student prijavljen, prikaži student meni
            while (true) {
                studentMenu(student); // Pozivamo studentMenu metodu za studenta
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