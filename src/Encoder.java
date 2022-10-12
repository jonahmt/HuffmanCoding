import java.io.File;
import java.util.HashMap;

/**
 * Encoder class to handle compressing plaintext to binary format.
 *
 * @author Jonah Tharakan
 */
public class Encoder {

    private String fileName;
    private FileUtil fileUtil;
    private String fileContents;
    private long initialSize;
    private HashMap<Character, Integer> countMap;

    /**
     * Creates a new Encoder object with file given by FILENAME.
     */
    public Encoder(String fileName) {
        // Initalizes fileUtil, initialSize, and fileContents to their correct values.
        this.fileName = fileName;
        fileUtil = new FileUtil();
        File file = new File(fileName);
        countMap = new HashMap<>();

        initialSize = file.length();
        fileContents = fileUtil.readFile(file);
        createCountMap();

        printCounts();
    }

    /**
     * Parses through the file contents and finds the frequency of each character.
     * Fills in the countMap data structure.
     */
    private void createCountMap() {
        for (int i = 0; i < fileContents.length(); i++) {
            char c = fileContents.charAt(i);
            if (!countMap.containsKey(c)) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }
    }

    /**
     * Utility/debugging method to print out the values in the countMap.
     */
    private void printCounts() {
        for (char c : countMap.keySet()) {
            if (c <= 32 || c >= 127) {
                System.out.printf("ASCII (%d) : %d%n", (int) c, countMap.get(c));
            } else {
                System.out.printf("%c (%d) : %d%n", c, (int) c, countMap.get(c));
            }
        }
    }

}
