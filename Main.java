import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main implements Sets {
    public static void main(String[] args) {
        Scanner preScan = null;
        Scanner suffScan = null;
        Scanner furScan = null;
        File preFile = new File("prefix.txt");
        File suffFile = new File("suffix.txt");
        File furFile = new File("fur.txt");
        try {
            preScan = new Scanner(preFile);
	        suffScan = new Scanner(suffFile);
            furScan = new Scanner(furFile);
		} catch (FileNotFoundException e) {
			System.out.print("File failure.");
			System.exit(0);
		}
        while (preScan.hasNext()) {
            prefix.add(preScan.next());
        }
        while (suffScan.hasNext()) {
            suffix.add(suffScan.next());
        }
        while(furScan.hasNextLine()) {
            furs.add(furScan.nextLine());
        }
        preScan.close();
        suffScan.close();
        furScan.close();
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