import java.util.ArrayList;
import java.util.Random;

public class Clan implements Sets {
    String name;
    Cat leader;
    Cat deputy;
    Warrior med;
    ArrayList<Warrior> warriors;
    ArrayList<Queen> queens;
    ArrayList<Cat> elders;

    public Clan() {
        Random rand = new Random();
        name = Util.genNamePart(prefix);
        leader = new Cat("star");
        deputy = new Cat();
        med = new Warrior();
        warriors = new ArrayList<>();
        queens = new ArrayList<>();
        elders = new ArrayList<>();
        // 5 to 10 warriors possible
        int warCount = 5 + rand.nextInt(6);
        for (int k = 0; k < warCount; k++)
            warriors.add(new Warrior());
        // 0 to 3 queens possible
        int queenCount = rand.nextInt(4);
        for (int k = 0; k < queenCount; k++)
            queens.add(new Queen());
        // 0 to 3 elders possible
        int elderCount = rand.nextInt(4);
        for (int k = 0; k < elderCount; k++)
            elders.add(new Cat());
        Sets.restoreSets();
    }

    public void printClan() {
        System.out.println(name + "Clan");
        System.out.println("\nLeader: " + leader.getDesc());
        System.out.println("\nDeputy: " + deputy.getDesc());
        System.out.println("\nMedicine Cat: " + med.getDesc());
        if (med.hasApprentice())
            System.out.println("Apprentice: " + med.getApprentice().getDesc());
        System.out.println("\nWarriors");
        for (Warrior warrior : warriors) {
            warrior.printCat();
            warrior.printApprentice();
        }
        System.out.println("\nApprentices");
        boolean appt = false;
        for (Warrior warrior : warriors) {
            if (warrior.hasApprentice()) {
                appt = true;
                System.out.println(warrior.getApprentice().getDesc());
            }
        }
        if (!appt)
            System.out.println("None");
        System.out.println("\nQueens");
        for (Queen queen : queens) {
            queen.printCat();
            queen.printKits();
        }
        System.out.println("\nElders");
        for (Cat elder : elders) {
            elder.printCat();
        }
        if (elders.size() == 0) {
            System.out.println("None");
        }
        System.out.println("\nKits");
        boolean haveKits = false;
        for (Queen queen : queens) {
            for (Cat kit : queen.getKits()) {
                haveKits = true;
                kit.printCat();
            }
        }
        if (!haveKits) System.out.println("None");
    }
    
}
