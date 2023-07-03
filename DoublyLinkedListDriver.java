
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

    /**
     * Start of main method.
     */
    public static void main (String[] args) {

        // Check if a command-line argument was provided
        if (args.length > 0) {
            String filename = args[0]; // Get the filename from the first command-line argument

            // Read the file
            try {
                File file = new File(filename);
                Scanner fileScanner = new Scanner(file);

            // Prompt user for list type
                System.out.print("Enter list type (i - int, d - double, s - string): ");
                Scanner inputScanner = new Scanner(System.in);
                String inputListType = inputScanner.nextLine();

                while (true) {
                    if (inputListType.equals("" + INT)) {
                        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
                        processCommands(list);
                        break;
                    } else if (inputListType.equals("" + DOUBLE)) {
                        DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            processCommands(list);
                            break;
                        }
                    } else if (inputListType.equals("" + STRING)) {
                        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            processCommands(list);
                            break;
                        }
                    } else {
                        System.out.println("Invalid list type. Please try again.");
                        inputListType = inputScanner.nextLine();
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        } else {
            System.out.println("No file specified.");
        }

    }
    private static <T> void processCommands(DoublyLinkedList<T> list) {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
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
            String inputCommand = inputScanner.nextLine();

            while (!inputCommand.equals("" + QUIT)) {
                boolean correctCommand = true;
                switch (inputCommand) {
                case "i":
                    System.out.print("The list is: ");
                    list.print();
                    System.out.print("Enter a value to insert: ");
                    T inputValue = inputScanner.nextLine();
                    list.insertItem(inputValue);
                    System.out.print("The list is: ");
                    list.print();
                    System.out.print("The reverse list: ");
                    list.printReverse();
                    break;
                }
            }
        }
    }
        /*       if (inputCommand.equals("" + QUIT)) {
                System.out.println("Program quitting...");
                return;
            }
        }
    }

        //while loop
        while (!inputCommand.equals("" + QUIT)) {
            boolean correctCommand = true;
            switch (inputCommand) {
                //i command
            case "" + INSERT:
                System.out.print("Enter a number to insert: ");
                String inputValue = scanner.nextLine();

                if (itemtype = new DoublyLinkedList<T>(number);
                System.out.print("Original list: ");
                list.printList();
                try {
                    list.insertItem(itemtype);
                } catch (Exception e) {
                    System.out.println("Sorry. You cannot insert the duplicate item");
                }
                System.out.print("New list: ");
                list.printList();
                break;

                //d command
            case "" + DELETE:
                System.out.print("Enter a number to delete: ");
                itemtype = new ItemType(Integer.parseInt(scanner.nextLine()));
                if (list.getLength() == 0) {
                    System.out.println("You cannot delete from an empty list");
                } else {
                    System.out.print("Original list: ");
                    list.printList();
                    list.deleteItem(itemtype);
                    System.out.print("New list: ");
                    list.printList();
                }
                break;

                //r command
            case "" + RESET_LIST:
                list.resetList();
                System.out.println("Iterator is reset");
                break;

                //p command
            case "" + PRINT_ALL:
                System.out.print("The list is: ");
                list.printList();
                break;

                //l command
            case "" + LENGTH:
                System.out.print("The length of the list is " + list.getLength() + "\n");
                break;

                //q command
            case "" + QUIT:
                System.out.println("Exiting the program...");
                break;

            default:
                //command is not valid
                correctCommand = false;
                break;
            }

            if (correctCommand) {
                System.out.print("Enter a command: ");
            } else {
                System.out.print("Invalid command try again: ");
            }
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("" + QUIT)) {
                System.out.println("Exiting the program...");
            }//if
        } // while
        }

    }
    private static <T> T parseItem(String item, Class<T> type) {
        try {
            if (type == Integer.class) {
                return type.cast(Integer.valueOf(item));
            } else if (type == Double.class) {
                return type.cast(Double.valueOf(item));
            } else if (type == String.class) {
                return type.cast(item);
            } else {
                throw new IllegalArgumentException("Invalid type.");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid item value in the file.", ex);
        }
        */

}
