import java.util.Random;

public class Warrior extends Cat {
    // A warrior is any cat who can have an apprentice
    // this includes medicine cats, leaders, deputies
    Cat apprentice = null;

    // warriors, deputies, medicine cats
    // all use this constructor
    public Warrior() {
        super();
        genApprentice();
    }

    // in the case that the warrior
    // is a leader, then the suffix
    // is "star"
    public Warrior(String suff) {
        super(suff);
        genApprentice();
    }

    // generating an apprentice for the warrior
    private void genApprentice() {
        // 25% chance of having an apprentice
        int chance = new Random().nextInt(4);
        if (chance == 0) {
            // all apprentices have the paw
            // suffix
            apprentice = new Cat("paw");
        }
    }

    // check if this warrior has an apprentice
    public boolean hasApprentice() {
        return apprentice != null;
    }

    public Cat getApprentice() {
        return apprentice;
    }

    // this is only for the medicine cat
    // because medicine cat apprentices
    // do not show up in the apprentice list
    public String getApprenticeString() {
        if (!hasApprentice())
            return "";
        // ex: Apprentice: Jaypaw - gray tabby tom with blue eyes
        return "\n\tApprentice: " + apprentice.toString();
    }

    // for all apprentices of leaders, deputies, and warriors
    // only display's the apprentice's name
    // because the full description is in the apprentice list
    public String getApprenticeName() {
        if (!hasApprentice())
            return "";
        // ex: Apprentice: Sandpaw
        return "\n\tApprentice: " + apprentice.getName();
    }
}