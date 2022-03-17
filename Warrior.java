import java.util.Random;
/*
 * @Author: Felix Taylor
 * @Description: Warrior class - a cat who can have an apprentice
 */
public class Warrior extends Cat {
    Cat apprentice = null;

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
        if (chance == 0) // all apprentices are "paw"
            apprentice = new Cat("paw");
    }

    /** 
     * @return boolean - whether or not this warrior has an apprentice
     */
    public boolean hasApprentice() {
        return apprentice != null;
    }

    /** 
     * @return Cat - apprentice
     */
    public Cat getApprentice() {
        return apprentice;
    }
    
    /** 
     * @return ex: Apprentice: Jaypaw - gray tabby tom with blue eyes
     * This is for the med cat apprentice, because they are displayed separately
     * from the other apprentices
     */
    public String getApprenticeString() {
        if (!hasApprentice())
            return "";
        return "\n\tApprentice: " + apprentice.toString();
    }

    /** 
     * @return String - eg Apprentice: Sandpaw
     */
    public String getApprenticeName() {
        if (!hasApprentice())
            return "";
        return "\n\tApprentice: " + apprentice.getName();
    }
}