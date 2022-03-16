import java.util.Random;

public class Warrior extends Cat {
    Warrior apprentice = null;
    public Warrior() {
        super();
        int chance = new Random().nextInt(3);
        if (chance == 0) {
            apprentice = new Warrior("paw");
            apprentices.add(apprentice);
        }
    }

    public Warrior(String suffix) {
        super(suffix);
    }
    public void printCat() {
        super.printCat();
        if (apprentice != null) {
            System.out.println("\tApprentice: " + apprentice.getName());
        }
    }

    public void printCat(boolean med) {
        super.printCat();
        if (apprentice != null) {
            System.out.print("\tApprentice: ");
            apprentice.printCat();
        }
    }
}
