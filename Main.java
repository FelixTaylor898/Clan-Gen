import java.util.Scanner;

class Main implements Sets {
    public static void main(String[] args) {
        Sets.createSets();
        Scanner scan = new Scanner(System.in);
        while (true) {
            CatUtil.printClan();
            String input = scan.nextLine();
            if (input.equals("q")) {
                scan.close();
                System.exit(0);
            }
        }
    }
}