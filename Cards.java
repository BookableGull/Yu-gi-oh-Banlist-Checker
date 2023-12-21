import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// def load():
//    res = {}
//    with open('cards.txt') as f:
//       for line in f:
//          name, amount = line.split('\t')
//          res[name] = int(amount)


public class Cards {
    private Map<String, Integer> cards = new HashMap<String, Integer>();

    public Cards() {
        try {
            Scanner f = new Scanner(new File("banlist.tsv"));
            while (f.hasNextLine()) {
                String[] line = f.nextLine().split("\t");
                cards.put(line[0], Integer.parseInt(line[1]));
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCard(String card) {
        return cards.getOrDefault(card, -1);
    }
}