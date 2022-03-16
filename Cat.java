import java.util.Random;

class Cat implements Sets {
    String name = null;
    String fur = null;
    String gender = new Random().nextInt(2) == 0 ? "tom" : "she-cat";

    public Cat() {
        String pre;
        String suff = CatUtil.genNamePart(suffix);
        do { pre = CatUtil.genNamePart(prefix); }
        while(pre.toLowerCase().equals(suff) || pre.length() + suff.length() == 12);
        prefix.remove(pre);
        preRemoved.add(pre);
        suffix.remove(suff);
        suffRemoved.add(suff);
        name = pre + suff;
        fur = CatUtil.genFur(gender);
    }


    public Cat(String suffix) {
        String pre = CatUtil.genNamePart(prefix);
        prefix.remove(pre);
        preRemoved.add(pre);
        name = pre + suffix;
        fur = CatUtil.genFur(gender);
    }

    public String getName() {
        return name;
    }

    public void printCat() { System.out.println(name + " - " +fur + " " + gender); }
  }