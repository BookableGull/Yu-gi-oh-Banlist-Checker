import java.io.FileWriter;
import java.util.Scanner;
// This is the main class
// Asks what card
// Looks up the card in the "database"
// On a separate txt file, writes how many copies it wants (prompt user)
// Repeat!

public class App {
    public static void main(String[] args) throws Exception {
        Cards cards = new Cards();
        Scanner input = new Scanner(System.in);
        FileWriter output = new FileWriter("output.txt");
        boolean running = true;
        try {
            while (running) {
                System.out.println("What card do you want? (type 'exit' to quit)");
                String card = input.nextLine();
                if (card.equals("exit")) {
                    running = false;
                    break;
                }
                int copies = cards.getCard(card);
                if (copies == -1) {
                    System.out.println("Card not found");
                } else {
                    System.out.println("How many copies do you want?");
                    System.out.println("(out of a max of " + copies + " cards)");
                    try {
                        int amount = input.nextInt();
                        input.nextLine();
                        if (amount > copies) {
                            System.out.println("Amount of copies not allowed");
                        } else {
                            output.write(card + "\t" + amount + "\n");
                        }
                    } catch (Exception e) {}
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            input.close();
            output.close();
        }
    }
}
