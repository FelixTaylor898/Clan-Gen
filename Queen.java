import java.util.ArrayList;
import java.util.Random;

public class Queen extends Cat {

    ArrayList<Cat> kits = new ArrayList<>();

    public Queen() {
        super();
        gender = "she-cat";
        desc = desc.replaceAll("tom", "she-cat");
        // Between 0 and 3 kits
        int kitC = new Random().nextInt(4);
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
        System.out.print(getKitsString());
    }

    public String getKitsString() {
        String result = "";
        if (hasKits()) {
            result += "\n\tKits: ";
            for (int k = 0; k < kits.size(); k++) {
                result += kits.get(k).getName();
                if (k + 1 < kits.size())
                    result += ", ";
            }
        }
        return result;
    }
}
