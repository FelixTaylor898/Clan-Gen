/**
 * @Author: Felix Taylor
 * @Description - queen object, any cat who can have kits
 */
import java.util.ArrayList;
import java.util.Random;

public class Queen extends Cat {

    ArrayList<Cat> kits = new ArrayList<>();
    String kitsString;

    public Queen() {
        super();
        // queen is always a she-cat
        gender = "she-cat";
        desc = desc.replaceAll("tom", "she-cat");
        // Between 0 and 3 kits
        int kitC = new Random().nextInt(4);
        for (int k = 0; k < kitC; k++) {
            kits.add(new Cat("kit"));
        }
        genKitsString();
    }

    /**
     * @return boolean - whether or not the queen has kits
     */
    public boolean hasKits() {
        return kits.size() > 0;
    }

    /**
     * @return ArrayList<Cat> - this queen's kits
     */
    public ArrayList<Cat> getKits() {
        return kits;
    }

    private void genKitsString() {
        String result = "";
        if (hasKits()) { // don't get string if empty
            result += "\n\tKits: ";
            for (int k = 0; k < kits.size(); k++) {
                result += kits.get(k).getName();
                if (k + 1 < kits.size())
                    result += ", "; // separate names with comma
            }
        }
        kitsString = result;
    }

    /**
     * @return String - lists the queen's kits
     * eg: Kits: Lionpaw, Hollypaw, Jaypaw
     */
    public String getKitsString() {
        return kitsString;
    }
}
