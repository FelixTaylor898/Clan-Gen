import java.util.ArrayList;
import java.util.Random;

public class Queen extends Cat {

    ArrayList<Kit> kits = new ArrayList<>();
    
    public Queen() {
        super();
        gender = "she-cat";
        int kitC = new Random().nextInt(3);
        while (kitC > 0) {
            kits.add(new Kit());
            kitC--;
        }
    }
    public void printCat() {
        super.printCat();
        System.out.print("\tKits: ");
        if (kits.size() == 0) {
            System.out.println("None");
        }
        for (int k = 0; k < kits.size(); k++) {
            kits.get(k).printCat();
            if (k + 1 < kits.size()) System.out.print(", ");
            else System.out.println();
        }
    }
}
