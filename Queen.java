import java.util.ArrayList;
import java.util.Random;

public class Queen extends Cat {

    ArrayList<Cat> kits = new ArrayList<>();
    
    public Queen() {
        super();
        gender = "she-cat";
        // Between 0 and 2 kits
        int kitC = new Random().nextInt(3);
        for (int k = 0; k < kitC; k++) {
            kits.add(new Cat("kit"));
        }
    }

    public boolean hasKits() {
        return kits.size() > 0;
    }

    public ArrayList<Cat> getKits() {
        return kits;
    }

    public void printKits() {
        if (hasKits()) {
            System.out.print("Kits: ");
            for (int k = 0; k < kits.size(); k++) {
                System.out.print(kits.get(k).getName());
                if (k + 1 < kits.size()) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
