import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Task 1 Afiseaza un mesaj de welcome.
        // Task 2 Salveaza intr o variabila un cuvant "avion".
        // Task 3 Afiseaza la consola un sir de stelute care sa reprezinte literele din cuvant.
        // Task 4 Cere de la user o litera apoi verifica daca litera este in cuvant.
        // Task 5 Daca da inlocuieste steluta de la pozitia respectiva cu litera ghicita.
        // Task 6 Daca nu sa se scada o viata dintre cele 10 vieti stabilite initial.
        // Task 7 Introdu toata logica intr un grup incepand cu task ul 3.
        // Task 8 Cand cuvantul este complet ghicit din litere afiseaza mesajul ai ghicit si opreste programul.
        // Task 9 Cand numarul de vieti ajunge la 0 afiseaza "Ai pierdut!" si opreste programul.

        System.out.println(Colors.BLUE + "Welcome!" + Colors.RESET);
        int lives = 10;
        int attempts = 0;
        ArrayList<String> words = new ArrayList<>(Arrays.asList("stereotype", "professor", "retreat", "branch",
                "product", "business", "system", "customer", "season", "nightmare", "incredible"));
        Random rnd = new Random();
        int index = rnd.nextInt(words.size());
        String hiddenWord = words.get(index);
        char[] stars = new char[hiddenWord.length()];
        Arrays.fill(stars, '*');
        while (true) {
            boolean letterIsFound = false;
            System.out.println(stars);
            Scanner scan = new Scanner(System.in);
            System.out.println(Colors.YELLOW + "Please write a letter." + Colors.RESET);
            char letter = scan.next().charAt(0);
            attempts++;
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (letter == hiddenWord.charAt(i)) {
                    stars[i] = letter;
                    letterIsFound = true;
                }
            }
            if (!letterIsFound){
                System.out.println(Colors.RED_BRIGHT + "Wrong choice!" + Colors.RESET);
                lives--;
            }
            if (!String.valueOf(stars).contains("*")){
                System.out.println(Colors.GREEN + "You guessed the word!" + Colors.RESET);
                System.out.println("You guessed in " + attempts + " attempts!");
                break;
            }
            if (lives == 0){
                System.out.println(Colors.RED + "You didn't guessed the word! \nYou lost!");
                break;
            }
        }
    }
}
