import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * DoublyLinkedListDriver class.
 */
public class DoublyLinkedListDriver<T extends Comparable<T>> {
    // Bipasha Bipin - instance variables for each command and generic list
    // implementation
    public static final char INSERT = 'i';
    public static final char DELETE = 'd';
    public static final char PRINT = 'p';
    public static final char LENGTH = 'l';
    public static final char PRINT_REV = 't';
    public static final char REVERSE = 'r';
    public static final char DELETE_SUB = 'b';
    public static final char SWAP_ALT = 's';
    public static final char QUIT = 'q';

    public static final char INT = 'I';
    public static final char DOUBLE = 'D';
    public static final char STRING = 'S';

    /**
     * Start of main method.
     */
    public static void main(String[] args) {

        // Check if a command-line argument was provided
        if (args.length > 0) {
            String filename = args[0]; // Get the filename from the first command-line argument
            Scanner scanner = new Scanner(System.in);
            // creating the scanner to read the file
            Scanner scanFile = null;
            try {
                File listFile = new File(filename);
                scanFile = new Scanner(listFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
                return;
            }

            // prompt the user for the data type of the list
            System.out.print("Enter list type (I - int, D - double, S - string): ");
            Scanner inputScanner = new Scanner(System.in);
            String dataType = inputScanner.nextLine();
            switch (dataType)
            {
                case "" + INT:
                    intDoublyLinkedList(scanner, scanFile, inputScanner);
                    break;
                case "" + STRING:
                    stringDoublyLinkedList(scanner, scanFile, inputScanner);
                    break;
                case "" + DOUBLE:
                    doubleDoublyLinkedList(scanner, scanFile, inputScanner);
                    break;
            }

        }
    }

    public static void intDoublyLinkedList(Scanner scanner, Scanner scanFile, Scanner inputScanner) {
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();
        String inputCommand = "";
        while (!inputCommand.equals("" + QUIT)) {
            boolean correctCommand = true;
            while (scanFile.hasNext()) {
                int fileItems = scanFile.nextInt();
                intList.insertItem(fileItems);

            }
            switch (inputCommand) {
                case "" + PRINT:
                    System.out.print("The list is : ");
                    intList.print();
                    break;

                case "" + PRINT_REV:
                    System.out.print("The reverse list: ");
                    intList.printReverse();
                    break;
                case "" + LENGTH:
                    System.out.println("The length of the list is " + intList.length());
                    break;
                case "" + INSERT:
                    System.out.print("The list is : ");
                    intList.print();
                    System.out.print("Enter a number to insert: ");
                    int input = inputScanner.nextInt();

                    if (!intList.searchItemBoolean(input)) {
                        intList.insertItem(input);
                    } else {
                        System.out.println("Item already exists");
                    }
                    System.out.print("The list is : ");
                    intList.print();
                    System.out.print("The reverse list: ");
                    intList.printReverse();
                    break;
                case "" + DELETE:
                    System.out.print("The list is : ");
                    intList.print();
                    System.out.print("Enter a number to delete: ");
                    input = inputScanner.nextInt();
                    try {
                        intList.deleteItem(input);
                    } catch (NoSuchElementException x) {
                        System.out.println("The item is not present in the list");
                    }
                    System.out.print("The list is : ");
                    intList.print();
                    System.out.print("The reverse list: ");
                    intList.printReverse();
                    break;
                case "" + REVERSE:
                    System.out.print("The original list: ");
                    intList.print();
                    System.out.print("The reverse list: ");
                    intList.reverseList();
                    intList.print();
                    break;
                case "" + DELETE_SUB:
                    System.out.print("Enter the lower bound: ");
                    int lowerBound = inputScanner.nextInt();
                    System.out.print("Enter the upper bound: ");
                    int upperBound = inputScanner.nextInt();
                    intList.deleteSubsection(upperBound, lowerBound);
                    System.out.print("The original list: ");
                    intList.print();
                    System.out.print("The reverse list is: ");
                    intList.printReverse();
                    break;
                case "" + SWAP_ALT:
                    System.out.print("The original list: ");
                    intList.print();
                    System.out.print("The modidied list: ");
                    intList.swapAlternate();
                    intList.print();
                    System.out.print("The reverse list: ");
                    intList.printReverse();
                    break;
                case "" + QUIT:
                    System.out.println("Exiting the program...");
                    break;

            }

            if (correctCommand) {
                System.out.println("Commands:\n");
                System.out.println("(i) - Insert value");
                System.out.println("(d) - Delete value");
                System.out.println("(p) - Print list");
                System.out.println("(l) - Length");
                System.out.println("(t) - Print reverse");
                System.out.println("(r) - Reverse list");
                System.out.println("(b) - Delete Subsection");
                System.out.println("(s) - Swap Alternate");
                System.out.println("(q) - Quit program");
                System.out.print("Enter a command: ");
            } else {
                System.out.print("Invalid command try again: ");
            }
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("" + QUIT)) {
                System.out.println("Exiting the program...");
            }
        }
    }

    public static void stringDoublyLinkedList(Scanner scanner, Scanner scanFile, Scanner inputScanner) {
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        String inputCommand = "";
        while (!inputCommand.equals("" + QUIT)) {
            boolean correctCommand = true;
            while (scanFile.hasNext()) {
                String fileItems = scanFile.nextLine();
                stringList.insertItem(fileItems);

            }
            switch (inputCommand) {
                case "" + PRINT:
                    System.out.print("The list is : ");
                    stringList.print();
                    break;

                case "" + PRINT_REV:
                    System.out.print("The reverse list: ");
                    stringList.printReverse();
                    break;
                case "" + LENGTH:
                    System.out.println("The length of the list is " + stringList.length());
                    break;
                case "" + INSERT:
                    System.out.print("The list is : ");
                    stringList.print();
                    System.out.print("Enter a number to insert: ");
                    String input = inputScanner.nextLine();

                    if (!stringList.searchItemBoolean(input)) {
                        stringList.insertItem(input);
                    } else {
                        System.out.println("Item already exists");
                    }
                    System.out.print("The list is : ");
                    stringList.print();
                    System.out.print("The reverse list: ");
                    stringList.printReverse();
                    break;
                case "" + DELETE:
                    System.out.print("The list is : ");
                    stringList.print();
                    System.out.print("Enter a number to delete: ");
                    input = inputScanner.nextLine();
                    try {
                        stringList.deleteItem(input);
                    } catch (NoSuchElementException x) {
                        System.out.println("The item is not present in the list");
                    }
                    System.out.print("The list is : ");
                    stringList.print();
                    System.out.print("The reverse list: ");
                    stringList.printReverse();
                    break;
                case "" + REVERSE:
                    System.out.print("The original list: ");
                    stringList.print();
                    System.out.print("The reverse list: ");
                    stringList.reverseList();
                    stringList.print();
                    break;
                case "" + DELETE_SUB:
                    System.out.print("Enter the lower bound: ");
                    String lowerBound = inputScanner.nextLine();
                    System.out.print("Enter the upper bound: ");
                    String upperBound = inputScanner.nextLine();
                    stringList.deleteSubsection(upperBound, lowerBound);
                    System.out.print("The original list: ");
                    stringList.print();
                    System.out.print("The reverse list is: ");
                    stringList.printReverse();
                    break;
                case "" + SWAP_ALT:
                    System.out.print("The original list: ");
                    stringList.print();
                    System.out.print("The modidied list: ");
                    stringList.swapAlternate();
                    stringList.print();
                    System.out.print("The reverse list: ");
                    stringList.printReverse();
                    break;
                case "" + QUIT:
                    System.out.println("Exiting the program...");
                    break;

            }

            if (correctCommand) {
                System.out.println("Commands:\n");
                System.out.println("(i) - Insert value");
                System.out.println("(d) - Delete value");
                System.out.println("(p) - Print list");
                System.out.println("(l) - Length");
                System.out.println("(t) - Print reverse");
                System.out.println("(r) - Reverse list");
                System.out.println("(b) - Delete Subsection");
                System.out.println("(s) - Swap Alternate");
                System.out.println("(q) - Quit program");
                System.out.print("Enter a command: ");
                inputCommand = scanner.nextLine();
            } else {
                System.out.print("Invalid command try again: ");
            }
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("" + QUIT)) {
                System.out.println("Exiting the program...");
            }
        }
    }

    public static void doubleDoublyLinkedList(Scanner scanner, Scanner scanFile, Scanner inputScanner) {
        DoublyLinkedList<Double> doubleList = new DoublyLinkedList<>();
        String inputCommand = "";
        while (!inputCommand.equals("" + QUIT)) {
            boolean correctCommand = true;
            while (scanFile.hasNext()) {
                Double fileItems = scanFile.nextDouble();
                doubleList.insertItem(fileItems);

            }
            switch (inputCommand) {
                case "" + PRINT:
                    System.out.print("The list is : ");
                    doubleList.print();
                    break;

                case "" + PRINT_REV:
                    System.out.print("The reverse list: ");
                    doubleList.printReverse();
                    break;
                case "" + LENGTH:
                    System.out.println("The length of the list is " + doubleList.length());
                    break;
                case "" + INSERT:
                    System.out.print("The list is : ");
                    doubleList.print();
                    System.out.print("Enter a number to insert: ");
                    Double input = inputScanner.nextDouble();

                    if (!doubleList.searchItemBoolean(input)) {
                        doubleList.insertItem(input);
                    } else {
                        System.out.println("Item already exists");
                    }
                    System.out.print("The list is : ");
                    doubleList.print();
                    System.out.print("The reverse list: ");
                    doubleList.printReverse();
                    break;
                case "" + DELETE:
                    System.out.print("The list is : ");
                    doubleList.print();
                    System.out.print("Enter a number to delete: ");
                    input = inputScanner.nextDouble();
                    try {
                        doubleList.deleteItem(input);
                    } catch (NoSuchElementException x) {
                        System.out.println("The item is not present in the list");
                    }
                    System.out.print("The list is : ");
                    doubleList.print();
                    System.out.print("The reverse list: ");
                    doubleList.printReverse();
                    break;
                case "" + REVERSE:
                    System.out.print("The original list: ");
                    doubleList.print();
                    System.out.print("The reverse list: ");
                    doubleList.reverseList();
                    doubleList.print();
                    break;
                case "" + DELETE_SUB:
                    System.out.print("Enter the lower bound: ");
                    Double lowerBound = inputScanner.nextDouble();
                    System.out.print("Enter the upper bound: ");
                    Double upperBound = inputScanner.nextDouble();
                    doubleList.deleteSubsection(upperBound, lowerBound);
                    System.out.print("The original list: ");
                    doubleList.print();
                    System.out.print("The reverse list is: ");
                    doubleList.printReverse();
                    break;
                case "" + SWAP_ALT:
                    System.out.print("The original list: ");
                    doubleList.print();
                    System.out.print("The modidied list: ");
                    doubleList.swapAlternate();
                    doubleList.print();
                    System.out.print("The reverse list: ");
                    doubleList.printReverse();
                    break;
                case "" + QUIT:
                    System.out.println("Exiting the program...");
                    break;

            }

            if (correctCommand) {
                System.out.println("Commands:\n");
                System.out.println("(i) - Insert value");
                System.out.println("(d) - Delete value");
                System.out.println("(p) - Print list");
                System.out.println("(l) - Length");
                System.out.println("(t) - Print reverse");
                System.out.println("(r) - Reverse list");
                System.out.println("(b) - Delete Subsection");
                System.out.println("(s) - Swap Alternate");
                System.out.println("(q) - Quit program");
                System.out.print("Enter a command: ");
                inputCommand = scanner.nextLine();
            } else {
                System.out.print("Invalid command try again: ");
            }
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("" + QUIT)) {
                System.out.println("Exiting the program...");
            }
        }
    }
}