import java.util.Scanner;

class Main implements Sets {
    public static void main(String[] args) {
        Sets.createSets();
        // new Frame();
        Scanner scan = new Scanner(System.in);
        while (true) {
            Clan clan = new Clan();
            clan.printClan();
            String input = scan.nextLine();
            if (input.equals("q")) {
                scan.close();
                System.exit(0);
            }
        }
    }
}