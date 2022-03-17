import java.util.ArrayList;
import java.util.Random;

public class Clan implements Sets {
    String name;
    Warrior leader;
    Warrior deputy;
    Warrior med;
    ArrayList<Warrior> warriors;
    ArrayList<Queen> queens;
    ArrayList<Cat> elders;
    String fullString;

    public Clan() {
        Random rand = new Random();
        name = Util.genRandomWord(prefix);
        leader = new Warrior("star");
        deputy = new Warrior();
        med = new Warrior();
        warriors = new ArrayList<>();
        warriors.add(leader);
        warriors.add(deputy);
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
        fullString = buildString();
    }

    public String toString() {
        return fullString;
    }

    private String buildString() {
        return name + "Clan" + "\nLeader: " + leader.toString() + leader.getApprenticeName() +
                "\nDeputy: " + deputy.toString() + deputy.getApprenticeName() +
                "\nMedicine Cat: " + med.toString() + med.getApprenticeString() +
                getWarriorsString() + getApprenticeString() + buildQueenString() +
                buildKitString() + buildElderString();
    }

    private String getWarriorsString() {
        String result = "\n\nWarriors";
        for (int k = 2; k < warriors.size(); k++)
            result += "\n" + warriors.get(k).toString() + warriors.get(k).getApprenticeName();
        return result;
    }

    private String getApprenticeString() {
        String result = "\n\nApprentices";
        boolean appt = false;
        for (Warrior warrior : warriors) {
            if (warrior.hasApprentice()) {
                appt = true;
                result += "\n" + warrior.getApprentice().toString();
            }
        }
        if (!appt) {
            result += "\nNone";
        }
        return result;
    }

    private String buildQueenString() {
        String result = "\n\nQueens";
        if (queens.size() == 0) {
            result += "\nNone";
        } else {
            for (Queen queen : queens) {
                result += "\n" + queen.toString() + queen.getKitsString();
            }
        }
        return result;
    }

    private String buildKitString() {
        String result = "\n\nKits";
        boolean kits = false;
        for (Queen queen : queens) {
            for (Cat kit : queen.getKits()) {
                kits = true;
                result += "\n" + kit.toString();
            }
        }
        if (!kits)
            result += "\nNone";
        return result;
    }

    private String buildElderString() {
        String result = "\n\nElders";
        if (elders.size() == 0) {
            result += "\nNone";
        } else {
            for (Cat elder : elders) {
                result += "\n" + elder.toString();
            }
        }
        return result;
    }
}