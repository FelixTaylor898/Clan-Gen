import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public interface Sets {
    Set<String> prefix = new HashSet<>();
    Set<String> suffix = new HashSet<>();
    Set<String> preRemoved = new HashSet<>();
    Set<String> suffRemoved = new HashSet<>();
    Set<String> furs = new HashSet<>();
    Set<String> eyes = new HashSet<>();
    ArrayList<Warrior> apprentices = new ArrayList<>();
    Map<Queen, ArrayList<Cat>> kits = new HashMap<>();


    static void restoreSets() {
        for (String pre : preRemoved) {
            prefix.add(pre);
        }
        for (String suff : suffRemoved) {
            suffix.add(suff);
        }
        preRemoved.clear();
        suffRemoved.clear();
        apprentices.clear();
        kits.clear();
    }

    static void createSets() {
        Scanner preScan = null;
        Scanner suffScan = null;
        Scanner furScan = null;
        Scanner eyeScan = null;
        File preFile = new File("prefix.txt");
        File suffFile = new File("suffix.txt");
        File furFile = new File("fur.txt");
        File eyeFile = new File("eyes.txt");
        try {
            preScan = new Scanner(preFile);
	        suffScan = new Scanner(suffFile);
            furScan = new Scanner(furFile);
            eyeScan = new Scanner(eyeFile);
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
        while(eyeScan.hasNextLine()) {
            eyes.add(eyeScan.nextLine());
        }
        preScan.close();
        suffScan.close();
        furScan.close();
        eyeScan.close();
    }
}
