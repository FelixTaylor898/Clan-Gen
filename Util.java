import java.util.Random;
import java.util.Set;

public class Util {
    public static String genNamePart(Set < String > names) {
        int i = 0;
        int num = new Random().nextInt(names.size());
        for (String name: names) {
            if (i == num) {
                return name;
            }
            i++;
        }
        return null;
    }
}