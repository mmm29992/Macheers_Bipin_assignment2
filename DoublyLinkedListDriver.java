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
                if (inputListType.equals("" + INT)) {
                    DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
                    while (fileScanner.hasNextLine()) {
                        int line = fileScanner.nextInt();
                        NodeType<Integer> nodeTypeValue = new NodeType<>();
                        list.insertItem(nodeTypeValue);

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
                            while (!inputCommand.equals("q")) {
                                boolean correctCommand = true;
                                switch (inputCommand) {
                                case "i":
                                    System.out.println("The list is: " + line);
                                    System.out.print("Enter a value to insert: ");
                                    Integer inputValue = Integer.parseInt(inputScanner.nextInt());
                                    list.insertItem(nodeTypeValue.info);
                                    System.out.print("The list is: ");
                                    list.print();
                                    System.out.print("The reverse list: ");
                                    list.printReverse();
                                    break;
                                case "d":
                                    System.out.println("The list is: " + line);
                                    System.out.print("Enter a number to delete: ");
                                    Integer deletedValue =
                                        Integer.parseInt(inputScanner.nextInt());
                                    list.deleteItem(deletedValue);
                                    System.out.print("The list is: ");
                                    list.print();
                                    System.out.print("The reverse list: ");
                                    list.printReverse();
                                    System.out.println("The item is not present in the list");
                                    break;
                                case "p":
                                    System.out.println("The list is: " + line);
                                case "l":
                                    System.out.print("The length of the list is ");
                                    list.length();
                                case "t":
                                    System.out.print("The reverse list: ");
                                    list.printReverse();

                                }
                            }
                        }
                    }
                }
                    /*
                } else if (inputListType.equals("" + DOUBLE)) {
                    DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
                    while (fileScanner.hasNextLine()) {
                        int line = fileScanner.nextDouble();
                        NodeType<Double> nodeTypeValue = new NodeType<>();
                        list.insertItem(nodeTypeValue);

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

                            while (!inputCommand.equals("q")) {
                                boolean correctCommand = true;
                                switch (inputCommand) {
                                case "i":
                                    System.out.println("The list is: " + line);
                                    System.out.print("Enter a value to insert: ");
                                    Double inputValue =
                                        Double.parseDouble(inputScanner.nextDouble());
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
                } else if (inputListType.equals("" + STRING)) {
                    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.next();
                        NodeType<String> nodeTypeValue = new NodeType<>();
                        list.insertItem(nodeTypeValue);
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

                            while (!inputCommand.equals("q")) {
                                boolean correctCommand = true;
                                switch (inputCommand) {
                                case "i":
                                    System.out.println("The list is: " + line);
                                    System.out.print("Enter a value to insert: ");
                                    String inputValue = inputScanner.nextLine();
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
                    } */else {
                    System.out.println("Invalid list type. Please try again.");
                    inputListType = inputScanner.nextLine();
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        } else {
            System.out.println("No file specified.");
        }

    }
}
