# Studentski Servis

# Informacioni Sistem za Studente

## Opis
Informacioni sistem za studente je Java konzolna aplikacija koja pruža funkcionalnost kako administratorima tako i studentima. Omogućava studentima da se prijave, pregledaju datume ispita i dodaju ispite na svoju listu. Administratori mogu upravljati informacijama o studentima i izvršavati administrativne zadatke. Ovaj README.md fajl pruža pregled strukture projekta i njegove funkcionalnosti.

## Sadržaj
- [Instalacija](#instalacija)
- [Upotreba](#upotreba)
- [Funkcionalnosti](#funkcionalnosti)
- [Doprinos](#doprinos)
- [Licenca](#licenca)

## Instalacija
Da biste pokrenuli ovaj projekat, pratite sledeće korake:

1. Klonirajte repozitorijum:
   ```bash
   git clone https://github.com/vasekorisnickoime/vas-repozitorijum.git
   cd vas-repozitorijum

## Upotreba
### Studenti
- Studenti se pozivaju da unesu svoje korisničko ime i lozinku kako bi se prijavili.
- Nakon prijave, studenti mogu:
  - Pregledati datume ispita za različite predmete.
  - Dodavati ispite u svoju ličnu listu.
  - Pregledati svoje prijavljene ispite.
  
### Administratori
- Administratori se mogu prijaviti koristeći podrazumevane podatke za prijavu (korisničko ime: "admin", lozinka: "admin").
* **Napomena**: Podaci bi trebali biti drugačiji od podrazumevanog.
- Nakon prijave kao administrator, mogu:
  - Pregledati listu dostupnih komandi.
  - Dodavati nove studente u sistem.
  - Brisati studente iz sistema.
  - Izlistati sve studente u sistemu.

## Funkcionalnosti
- Autentifikacija i autorizacija korisnika.
- Upravljanje informacijama o studentima.
- Prikazivanje datuma ispita i registracija.
- Komandna linija za administratore.
- Jednostavan interfejs za studente.
- Dinamičko učitavanje datuma ispita i predmeta.

## Licenca
Ovaj projekat je licenciran pod MIT licencom. Slobodno ga koristite, modifikujte i distribuirajte prema potrebama.

