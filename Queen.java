import java.util.ArrayList;
import java.util.Random;

public class Queen extends Cat {
    
    public Queen() {
        super();
        gender = "she-cat";
        int kitC = new Random().nextInt(4);
        kits.put(this, new ArrayList<Cat>());
        while (kitC > 0) {
            kits.get(this).add(new Cat("kit"));
            kitC--;
        }
    }
    public void printCat() {
        super.printCat();
        System.out.print("\tKits: ");
        ArrayList<Cat> myKits = kits.get(this);
        if (myKits.size() == 0) {
            System.out.println("None");
        }
        for (int k = 0; k < myKits.size(); k++) {
            System.out.print(myKits.get(k).getName());
            if (k + 1 < myKits.size()) System.out.print(", ");
            else System.out.println();
        }
    }
}
