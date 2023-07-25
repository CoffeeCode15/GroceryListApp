import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contenuto :Programma Gestione lista spesa.
 * Autore : Giacalone Riccardo.
 */
public class Market {
    //Lista prodotti supermerato.
    public static List<String> productList = new ArrayList<>();

    //Creazione scanner per input.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean exit = false;
//Opzioni menu.
        while (!exit) {
            System.out.println(" Selezione un'opzione : ");
            System.out.println(" 1. Aggiungi un prodotto :");
            System.out.println(" 2. Rimuovi un prodotto : ");
            System.out.println(" 3. Visulazza lista prodotti :");
            System.out.println(" 4. Esci .");
            //Legge l'input dell'utente.
            int choice = scanner.nextInt();
// Legge il carattere successivo all'input dell'utente.
            scanner.nextLine();
//Utilizzo di Switch per gestire le opzioni dell'utente.
            switch (choice) {
                //Case 1 per aggiungere prodotto.
                case 1:
                    System.out.println("Inserisci nome prodotto : ");
                    String newProduct = scanner.nextLine();
                    addProduct(newProduct);
                    break;
                //Case 2 per rimuoevre prodotto.
                case 2:
                    System.out.println("Rimuovi prodotto : ");
                    String productToRemove = scanner.nextLine();
                    removeProduct(productToRemove);
                    break;

                case 3:
                    dysplayProductList();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci! ");
                    break;

                default:
                    System.out.println("Comando non valido. Riprovare.");
                    break;
            }
        }
    }









