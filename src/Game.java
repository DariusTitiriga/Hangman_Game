import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
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
            if (!letterIsFound) {
                System.out.println(Colors.RED_BRIGHT + "Wrong choice!" + Colors.RESET);
                lives--;
            }
            if (!String.valueOf(stars).contains("*")) {
                System.out.println(Colors.GREEN + "You guessed the word!" + Colors.RESET);
                System.out.println("You guessed in " + attempts + " attempts!");
                break;
            }
            if (lives == 0) {
                System.out.println(Colors.RED + "You didn't guessed the word! \nYou lost!" + Colors.RESET);
                break;
            }
        }
    }
}
