import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            //Ustalamy działy i ich pracowników
            DzialPracownikow dzialProgramistow = DzialPracownikow.createDzial("IT");
            Pracownik programista1 = new Pracownik("Jan", "Kowalski", new Date(90, 5, 10), dzialProgramistow);
            Pracownik programista2 = new Pracownik("Anna", "Nowak", new Date(85, 8, 20), dzialProgramistow);


            DzialPracownikow dzialSprzedazy = DzialPracownikow.createDzial("SALES");
            Pracownik sprzedawca1 = new Pracownik("Marek", "Jankowski", new Date(88, 2, 15), dzialSprzedazy);
            Pracownik sprzedawca2 = new Pracownik("Katarzyna", "Nowicka", new Date(92, 11, 1), dzialSprzedazy);

            //Ustalamy specjalistów i ich specjalizacje
            Specjalista programista3 = new Specjalista("Adam", "Murek", new Date(), dzialProgramistow, "Java");
            Specjalista sprzedawca3 = new Specjalista("Tomasz", "Lewandowski", new Date(), dzialSprzedazy, "B2C");
            //Zbiór wszystkich pracowników
            System.out.println("Pracownicy:");
            for (Pracownik pracownik : Pracownik.getPracownicy()) {
                System.out.println(pracownik);
            }
            //Wymiana specjalistów i ich specjalizacji
            System.out.println("Specjalizacją pracownika " + programista3.getSpecjalista() + " z " + programista3.getDzial() + " jest " + programista3.getSpecjalizacja());
            System.out.println("Specjalizacja pracownika " + sprzedawca3.getSpecjalista() + " z " + sprzedawca3.getDzial() + " jest " + sprzedawca3.getSpecjalizacja());

            Brygadzista brygadzista1 = new Brygadzista("Marcin", "Kowal", new Date(90, 5, 10), dzialProgramistow, "login123", "haslo123", "brygada1");
            Brygada brygada1 = new Brygada("brygada1", brygadzista1, new ArrayList<>());
            System.out.println("Brygada: " + brygada1.getNazwa() + " brygadzista: " + brygada1.getBrygadzista().getInicjal());

            brygada1.dodajPracownika(programista1);
            brygada1.dodajPracownika(programista2);
            System.out.println("Pracownicy brygady: " + brygada1.getPracownicy());

            Uzytkownik uzytkownik1 = new Uzytkownik("Jan", "Kowalski", new Date(90, 5, 10), dzialProgramistow, "login123", "haslo123");
            System.out.println("Uzytkownik: " + uzytkownik1.getInicjal());


        } catch (NotUniqueException e) {
            System.out.println(e.getMessage());
        }


    }
}