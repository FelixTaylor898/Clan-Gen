import java.util.Random;
class Cat implements Sets {
    String name;
    String eye = Util.genRandomWord(eyes);
    // 50/50 chance of either
    String gender = new Random().nextInt(2) == 1 ? "tom" : "she-cat";
    String fur = genFur();
    String desc;

    /*
     * Cat object default constructor
     * When a cat does not need a particular
     * suffix
     */
    public Cat() {
        String pre;
        String suff = Util.genRandomWord(suffix); // generate suffix
        do {
            pre = Util.genRandomWord(prefix);
        } // generate prefix
        while (pre.toLowerCase().equals(suff) || pre.length() + suff.length() > 10);
        // prefix and suffix can't be the same, and the name can't be more than 10
        // characters
        suffix.remove(suff); // suffix can't be used twice
        suffRemoved.add(suff); // so the suffix can be restored later
        constHelper(pre, suff); // things that both constructors do
    }

    /**
     * When a cat needs a particular suffix
     * @param suffix - eg "star," "paw," or "kit"
     */
    public Cat(String suffix) {
        String pre = Util.genRandomWord(prefix); // generate any prefix
        constHelper(pre, suffix); // things that both constructors do
    }
    
    /** 
     * @param pre - cat name prefix
     * @param suff - cat name suffix
     */
    private void constHelper(String pre, String suff) {
        prefix.remove(pre); // prefix can't be used more than once
        preRemoved.add(pre); // so the prefix can be restored later
        name = pre + suff; // combine prefix and suffix for name
        // ex: Fireheart - ginger tabby tom with green eyes
        desc = name + " - " + fur + " " + gender + " with " + eye + " eyes";
    }

    
    /** 
     * @return String - cat name, eg Fireheart, Bluestar
     */
    public String getName() {
        return name;
    }

    /** 
     * @return String - cat full description
     * eg: Cloudtail - long-haired white tom with blue eyes
     */
    public String toString() {
        return desc;
    }

    /** 
     * @return String - generate cat's fur
     * the color plus the length
     */
    private String genFur() {
        String fur = Util.genRandomWord(furs);
        String len = "";
        if (new Random().nextInt(5) == 0)
            len = "long-haired ";
        // toms cannot be tricolor cats
        if (gender.equals("she-cat") || (!fur.contains("tortoiseshell") && !fur.contains("calico")))
            return len + fur;
        return genFur();
    }
}