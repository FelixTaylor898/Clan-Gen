import java.util.Random;
import java.util.Set;

public class CatUtil implements Sets{
    public static String genNamePart(Set<String> names) {
        int i = 0;
        int num = new Random().nextInt(names.size());
        for (String name : names) {
            if (i == num) {
                return name;
            }
            i++;
        }
        return null;
    }

    private static String genLength() {
        if (new Random().nextInt(5) > 0) {
            return "";
        }
        return "long-haired ";
    }

    public static String genFur(String gender) {
        int i = 0;
        int num = new Random().nextInt(furs.size());
        for (String fur : furs) {
            if (i == num) {
                if (gender.equals("she-cat") || (!fur.contains("tortoiseshell") && !fur.contains("calico")))
                return genLength() + fur;
                else return genFur(gender);
            }
            i++;
        }
        return null;
    }

    public static void printClan() {
        apprentices.clear();
        String clan = genNamePart(prefix);
        System.out.println(clan + "Clan\n");
        System.out.print("Leader: ");
        new Warrior("star").printCat();
        System.out.print("\nDeputy: ");
        new Warrior().printCat();
        System.out.print("\nMedicine Cat: ");
        int init = apprentices.size();
        new Warrior().printCat(true);
        int now = apprentices.size();
        if (now > init) apprentices.remove(apprentices.size() - 1);
        System.out.println("\nWarriors");
        int warriors = 5 + new Random().nextInt(10);
        while (warriors > 0) {
            new Warrior().printCat();
            warriors--;
        }
        System.out.println("\nApprentices");
        if (apprentices.size() == 0) {
            System.out.println("None");
        }
        for (Warrior apprentice : apprentices) {
            apprentice.printCat();
        }
        System.out.println("\nQueens");
        int queens = new Random().nextInt(5);
        if (queens == 0) System.out.println("None");
        while (queens > 0) {
            new Queen().printCat();
            queens--;
        }
        System.out.println("\nElders");
        int elders = new Random().nextInt(5);
        if (elders == 0) System.out.println("None");
        while (elders > 0) {
            new Cat().printCat();
            elders--;
        }
        for (String pre : preRemoved) {
            prefix.add(pre);
        }
        for (String suff : suffRemoved) {
            suffix.add(suff);
        }
        preRemoved.clear();
        suffRemoved.clear();
    }
    
}
