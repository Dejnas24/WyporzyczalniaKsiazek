/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacjanazaliczenie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andrzej Dejnas Vel Denek
 */
public class APlikacjaNaZaliczenie {

    public static void main(String[] args) {

        List<Pozycz> list = new ArrayList<>();
        String tytul;
        String porzyczyl;
        String data;
        String informacje;

        SimpleDateFormat formatdaty = new SimpleDateFormat("yyyy.MM.dd");
        try {

            Scanner in = new Scanner(System.in, "utf-8");

            while (in.hasNextLine()) {
                Scanner line = new Scanner(in.nextLine()).useDelimiter(";");
                String operacja = line.next();

                switch (operacja.toUpperCase()) {
                    case "D":
                        try {
                            tytul = line.next();
                            porzyczyl = line.next();
                            data = line.next();
                            formatdaty.parse(data);
                            informacje = line.next();
                            list.add(new Pozycz(tytul, porzyczyl, data, informacje));
                        } catch (ParseException ex) {
                            System.out.println("Nie prawidlowy format daty.");
                        } catch (Exception e) {
                            System.out.println("Nie dodano odpowiednia ilość danych do listy...");
                        }

                        break;
                    case "U":
                        tytul = line.next();
                        try {
                            for (Pozycz p : list) {
                                if (p.getTytul().equals(tytul)) {
                                    list.remove(p);
                                    System.out.println("Usunięto: " + p);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Nie ma Plyty na liście...");
                        }

                        break;
                    case "L":

                        for (Pozycz p : list) {

                            System.out.println(p);
                        }
                        break;

                    case "LF": //???? nie mogę znaleść odpowiedniego rozwiązania do filtrowania pojedynczych nazw 

                        String klucz = line.next();
                        for (Pozycz p : list) {

                            if (klucz.equals(p.getTytul()) || klucz.equals(p.getPozyczyl()) || klucz.equals(p.getData()) || klucz.equalsIgnoreCase(p.getInformacje())) {
                                System.out.println(p);
                            }

                        }
                        break;

                    case "S":

                        String operacja1 = line.next();

//// pierwszy sposub dłuzszy, lepiej się sprawdza 
                        if (operacja1.equals("1")) {
                            Collections.sort(list, new Comparator<Pozycz>() {
                                @Override
                                public int compare(Pozycz o1, Pozycz o2) {

                                    return o1.getTytul().compareTo(o2.getTytul());

                                }

                            });

                            for (Pozycz p : list) {
                                System.out.println(p);
                            }
                        } else if (operacja1.equals("2")) {
                            Collections.sort(list, new Comparator<Pozycz>() {
                                @Override
                                public int compare(Pozycz o1, Pozycz o2) {

                                    return o1.getPozyczyl().compareTo(o2.getPozyczyl());

                                }

                            });

                            for (Pozycz p : list) {
                                System.out.println(p);
                            }
                        } else if (operacja1.equals("3")) {
                            Collections.sort(list, new Comparator<Pozycz>() {
                                @Override
                                public int compare(Pozycz o1, Pozycz o2) {

                                    return o1.getData().compareTo(o2.getData());

                                }

                            });

                            for (Pozycz p : list) {
                                System.out.println(p);
                            }
                        } else {
                            System.out.println("Nie ma takiej operacji, aby wykonac użyj następujące operacje:");
                            System.out.println("1 - sortowanie tytułów;");
                            System.out.println("2 - sortowanie pożyczonych;");
                            System.out.println("3 - sortowanie dat;");
                        }

                        // sposob po skruceniu                              
//                            Collections.sort(list, new Comparator<Pozycz>() {
//                                @Override
//                                public int compare(Pozycz o1, Pozycz o2) {
//                                    
//                            if (operacja1.equals("1")) {
//                                    return o1.getTytul().compareTo(o2.getTytul());
//                            }
//                           else if (operacja1.equals("2")) {
//                                    return o1.getPozyczyl().compareTo(o2.getPozyczyl());
//                            }
//                         else   if (operacja1.equals("3")) {
//                                    return o1.getData().compareTo(o2.getData());
//                            }
//                            else {
////                            System.out.println("Nie ma takiej operacji, aby wykonac użyj następujące operacje:");
////                            System.out.println("1 - sortowanie tytułów;");
////                            System.out.println("2 - sortowanie pożyczonych;");
////                            System.out.println("3 - sortowanie dat;");
//                            return 0;
//                        }
//
//                                }
//
//                            });
//                            
//                            for (Pozycz p : list) {
//                                System.out.println(p);
//                            }
                        break;

                    case "W":
                        try {
                            //   System.out.println("Podaj scieżkę do pliku np. w formacie: \"C:\\\\nazwa_ścieżki\\\\wnazwa_pliku.txt\" ");
                            String wprowadz = line.next();
                            PrintWriter zapis = new PrintWriter(wprowadz);
                            for (Pozycz z : list) {
                                zapis.println(z);
                            }
                            zapis.close();
                        } catch (FileNotFoundException ex) {
                            System.out.println("Brak takiej ścieżki do pliku lub jest nie poprawna...");
                        }

                        break;

                    case "R": //tylko w tym , że po odczycie kończy operację, nieche dalej program wykonywać się
                        // System.out.println("Podaj scieżkę do pliku np. w formacie: \"C:\\\\nazwa_ścieżki\\\\wnazwa_pliku.txt\" ");

                        String wprowadzOdczyt = line.next();
                        File odczytpliku = new File(wprowadzOdczyt);

                        try {
                            in = new Scanner(odczytpliku);
                            while (in.hasNextLine()) {
                                line = new Scanner(in.nextLine()).useDelimiter(";");
                                tytul = line.next();
                                porzyczyl = line.next();
                                data = line.next();
                                formatdaty.parse(data);
                                informacje = line.next();
                                list.add(new Pozycz(tytul, porzyczyl, data, informacje));

                            }
                            for (Pozycz odczyt : list) {
                                System.out.println(odczyt);
                            }
                        } catch (ParseException ex) {
                            System.out.println("Nie prawidlowy format daty.");
                        } catch (FileNotFoundException ex) {
                            System.out.println("Brak pliku...");
                        }

                        break;

                    case "QUIT":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Brak takiej operacji, aby wykonać użyj następujących: ");
                        System.out.println("D - dodaj do listy;");
                        System.out.println("U - usun płytę z listy;");
                        System.out.println("L - wyświetl płyty z listy;");
                        System.out.println("LF - wyswietl płytę po zastosowaniu filtra;");
                        System.out.println("S - posortuj wedłóg wybranych kolumn;");
                        System.out.println("W - zapisz listy do pliku testowego;");
                        System.out.println("R - odczyt listy z pliku testowego;");
                        System.out.println("QUIT - wyjście z programu.");
                        break;

                }

            }
            in.close();
        } catch (Exception e) {
            System.out.println("Brak takiej operacji, aby wykonać użyj następujących: ");
            System.out.println("D - dodaj do listy;");
            System.out.println("U - usun płytę z listy;");
            System.out.println("L - wyświetl płyty z listy;");
            System.out.println("LF - wyswietl płytę po zastosowaniu filtra;");
            System.out.println("S - posortuj wedłóg wybranych kolumn;");
            System.out.println("W - zapisz listy do pliku testowego;");
            System.out.println("R - odczyt listy z pliku testowego;");
            System.out.println("QUIT - wyjście z programu.");

        }

    }

}
