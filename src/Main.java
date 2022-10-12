/**
 * Main class for Huffman Coding application.
 *
 * @author Jonah Tharakan
 */
public class Main {

    /**
     * Parses command arguments and calls the appropriate operation.
     * ARGS is the array of inputs.
     *
     * Possible commands:
     * "help"
     * "command" "file name" "flags"(optional)
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            invalidInput(args);
            System.exit(0);
        }

        // Switch on command
        switch (args[0]) {
            case "encode":
                encode(args);
        }

    }

    /**
     * The command for compressing a plaintext file into binary via Huffman encoding.
     * Method first validates that the file exists. Then,
     * method creates an Encoder object which will handle the process.
     */
    private static void encode(String[] args) {
        Encoder encoder = new Encoder(args[1]);
    }

    private static void invalidInput(String[] args) {
        System.out.println("Your input command of ");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            s.append(args[i]).append(" ");
        }
        if (args.length == 0) {
            System.out.println("- BLANK -");
        } else {
            System.out.println(s.toString());
        }
        System.out.println("is invalid. Please run with command \"help\" for a list/description \nof possible commands.");
    }

}
