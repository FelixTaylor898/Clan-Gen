import java.util.Random;

class Cat implements Sets {
    String name = null;
    String fur = null;
    String eye = null;
    String gender = new Random().nextInt(2) == 0 ? "tom" : "she-cat";

    public Cat() {
        String pre;
        String suff = CatUtil.genNamePart(suffix);
        do { pre = CatUtil.genNamePart(prefix); }
        while(pre.toLowerCase().equals(suff) || pre.length() + suff.length() > 10);
        suffix.remove(suff);
        suffRemoved.add(suff);
        constHelper(pre, suff);
    }

    public Cat(String suffix) {
        String pre = CatUtil.genNamePart(prefix);
        constHelper(pre, suffix);
    }

    private void constHelper(String pre, String suff) {
        prefix.remove(pre);
        preRemoved.add(pre);
        name = pre + suff;
        fur = CatUtil.genFur(gender);
        eye = CatUtil.genEyes();
    }

    public String getName() {
        return name;
    }

    public void printCat() { System.out.println(name + " - " + fur + " " + gender + " with " + eye + " eyes"); }
  }