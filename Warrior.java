import java.util.Random;

public class Warrior extends Cat {
    // A warrior is any cat who can have an apprentice
    // this includes medicine cats
    Cat apprentice = null;

    public Warrior() {
        super();
        // 25% chance of having an apprentice
        int chance = new Random().nextInt(4);
        if (chance == 0) {
            apprentice = new Cat("paw");
        }
    }

    public boolean hasApprentice() {
        return apprentice != null;
    }

    public Cat getApprentice() {
        return apprentice;
    }

    public void printApprentice() {
        if (hasApprentice()) {
            System.out.println("Apprentice: " + apprentice.getName());
        }
    }

    public String getApprenticeString() {
        if (!hasApprentice())
            return "";
        return "\nApprentice: " + apprentice.toString();
    }

    public String getApprenticeName() {
        if (!hasApprentice())
            return "";
        return "\nApprentice: " + apprentice.getName();
    }
}
