import java.util.Random;

/*
 * @author: Felix Taylor
 * Cat object
 */
class Cat implements Sets {
    String name;
    String eye = genEyes();
    // 50/50 chance of either
    String gender = new Random().nextInt(2) == 1 ? "tom" : "she-cat";
    String fur = genFur();
    String length = genLength();
    String desc;

    /*
     * Cat object default constructor
     */
    public Cat() {
        String pre;
        String suff = Util.genNamePart(suffix); // generate suffix
        do {
            pre = Util.genNamePart(prefix);
        } // generate prefix
        while (pre.toLowerCase().equals(suff) || pre.length() + suff.length() > 10);
        // prefix and suffix can't be the same, and the name can't be more than 10
        // characters
        suffix.remove(suff); // suffix can't be used twice
        suffRemoved.add(suff); // so the suffix can be restored later
        constHelper(pre, suff); // things that both constructors do
    }

    /*
     * Cat object constructor
     * that takes in a suffix
     * such as "star" or "paw"
     */
    public Cat(String suffix) {
        String pre = Util.genNamePart(prefix); // generate any prefix
        constHelper(pre, suffix); // things that both constructors do
    }

    private void constHelper(String pre, String suff) {
        prefix.remove(pre); // prefix can't be used more than once
        preRemoved.add(pre); // so the prefix can be restored later
        name = pre + suff; // combine prefix and suffix for name
        // ex: Fireheart - ginger tabby tom with green eyes
        desc = name + " - " + length + fur + " " + gender + " with " + eye + " eyes";
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return desc;
    }

    /*
     * Generates cat fur length
     * 25% chance of long fur
     */
    private String genLength() {
        if (new Random().nextInt(5) > 0)
            return "";
        return "long-haired ";
    }

    /*
     * Generates cat eye color
     */
    private static String genEyes() {
        int num = new Random().nextInt(eyes.size());
        int i = 0;
        for (String eye : eyes) {
            if (num == i) {
                return eye;
            }
            i++;
        }
        return "green"; // default
    }

    /*
     * Generate fur color
     */
    private String genFur() {
        int i = 0;
        int num = new Random().nextInt(furs.size());
        for (String fur : furs) {
            if (i == num) {
                // males cannot be tri-color cats
                if (gender.equals("she-cat") || (!fur.contains("tortoiseshell") && !fur.contains("calico")))
                    return fur;
                else
                    return genFur();
            }
            i++;
        }
        return "gray"; // default
    }
}