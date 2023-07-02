
import NodeType;
import DoublyLinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * DoublyLinkedListDriver class.
 */
public class DoublyLinkedListDriver<T extends Comparable<T>> {
    //Bipasha Bipin - instance variables for each command and generic list implementation
    public static final char INSERT = 'i';
    public static final char DELETE = 'd';
    public static final char PRINT = 'p';
    public static final char LENGTH = 'l';
    public static final char PRINT_REV = 't';
    public static final char REVERSE = 'r';
    public static final char DELETE_SUB = 'b';
    public static final char SWAP_ALT = 's';
    public static final char QUIT = 'q';

    public static final char INT = 'i';
    public static final char DOUBLE = 'd';
    public static final char STRING = 's';

    private DoublyLinkedList<T> list;

    public DoublyLinkedListDriver(DoublyLinkedList<T> list) {
        this.list = list;
    }

    /**
     * Start of main method.
     */
    public static void main (String[] args) {

        DoublyLinkedListDriver<T> driver = new DoublyLinkedListDriver<T>(null);

        Scanner scanner = new Scanner(System.in);

        //Bipasha Bipin - starting to prompt user for list type

        while (true) {
            System.out.println("Enter list type (i - int, d - double, s - string)");
            String inputListType = scanner.nextLine();

            if (inputListType.equals("" + INT)) {
                driver.list = new DoublyLinkedList<Integer>();
                break;
            } else if (inputListType.equals("" + DOUBLE)) {
                driver.list = new DoublyLinkedList<Double>();
                break;
            } else if (inputListType.equals("" + STRING)) {
                driver.list = new DoublyLinkedList<String>();
                break;
            } else {
                System.out.println("Invalid list type. Try again.");
            }
            // Check conditions and return if necessary
            if (driver.list == null) {
                System.out.println("Failed to create list.");
                scanner.close();
                return;
            }

            if (args.length == 0) {
                System.out.println("Please give an input file.");
                scanner.close();
                return;
            }
        }

        //Bipasha Bipin - Beginning of implementing how to accept file in command line
        String inputFile = args[0];
        // Creating the scanner to read the file
        Scanner scanFile = null;
        try {
            File listFile = new File(inputFile);
            scanFile = new Scanner(listFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        // Putting the list from file into DoublyLinkedList
        while (scanFile.hasNext) {
            int fileItems = scanFile.nextInt();
            T itemTypeValue = new T(fileItems);
            driver.list.insertItem(itemTypeValue);
        }
        // End of accepting the file

                System.out.println("Commands:");
                System.out.println("(i) - Insert value");
                System.out.println("(d) - Delete value");
                System.out.println("(p) - Print list");
                System.out.println("(l) - Length");
                System.out.println("(t) - Print reverse");
                System.out.println("(r) - Reverse list");
                System.out.println("(b) - Delete Subsection");
                System.out.println("(s) - Swap Alternate");
                System.out.println("(q) - Quit program");
