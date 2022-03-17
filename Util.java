import java.util.Random;
import java.util.Set;

public class Util {
    // Generating a random word from a list
    public static String genRandomWord(Set<String> list) {
        int i = 0;
        int num = new Random().nextInt(list.size());
        for (String item : list) {
            if (i == num) {
                return item;
            }
            i++;
        }
        return null;
    }
}