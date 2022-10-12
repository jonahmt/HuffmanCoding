import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Primary class for interacting with files. Handles reading and writing.
 *
 * @author Jonah Tharakan
 */
public class FileUtil {

    /**
     * Creates a new FileUtil
     */
    public FileUtil() {}

    /**
     * Takes in File F and reads its contents, returning them as a String.
     */
    public String readFile(File f) {
        StringBuilder result = new StringBuilder();
        Scanner sc = null;

        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File " + f.getName() + " could not be opened. Check to make sure that it exists.");
            System.exit(0);
        }

        while (sc.hasNextLine()) {
            result.append(sc.nextLine() + '\n');
        }
        return result.toString();
    }

}
