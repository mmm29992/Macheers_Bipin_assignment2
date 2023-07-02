
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

        //Bipasha Bipin - beginning of implementing how to accept file in command line
        String inputFile = args[0];
        // creating the scanner to read the file
        Scanner scanFile = null;
        try {
            File listFile = new File(inputFile);
            scanFile = new Scanner(listFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        // putting the list from file into DoublyLinkedList
        while (scanFile.hasNext) {
            String fileItems = scanFile.next();
            T itemTypeValue;
            if (driver.list.insertItem(itemTypeValue);
        }
        // end of accepting the file

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


        System.out.print("Enter a command: ");
        String inputCommand = scanner.nextLine();
        T itemType = null;
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

                //s command
            case "" + SEARCH:
                System.out.print("Enter a number to search: ");
                itemtype = new ItemType(Integer.parseInt(scanner.nextLine()));
                System.out.print("Original list: ");
                list.printList();
                if (list.getLength() == 0) {
                    System.out.println("The list is empty");
                } else if (list.searchItem(itemtype) == -1) {
                    System.out.println("Item is not present in the list");
                } else {
                    System.out.println("The item is present at index " + list.searchItem(itemtype));
                }
                break;
                //n command
            case "" + GET_NEXT:
                list.getNextItem();
                break;

                //r command
            case "" + RESET_LIST:
                list.resetList();
                System.out.println("Iterator is reset");
                break;

                //a command
            case "" + DEL_ALT:
                System.out.print("Original list: ");
                list.printList();
                newList = list.deleteAlternateNodes(list);
                System.out.print("New list: ");
                newList.printList();
                break;

                //m command
            case "" + MERGE:
                System.out.print("Enter the length of the new list: ");
                int length = scanner.nextInt();
                System.out.print("Enter the numbers: ");
                SortedLinkedList mergeList = new SortedLinkedList();
                for (int i = 0; i < length; i++) {
                    mergeList.insertItem(new ItemType(scanner.nextInt()));
                }

                System.out.print("The list 1: ");
                list.printList();
                System.out.print("The list 2: ");
                mergeList.printList();
                mergeList = list.mergeList(list, mergeList);
                System.out.print("Merged list: ");
                mergeList.printList();
                scanner.nextLine();
                break;

                //t command
            case "" + INTERSECTION:
                System.out.print("Enter the length of the new list: ");
                int numLength = scanner.nextInt();
                System.out.print("Enter the numbers: ");
                newList = new SortedLinkedList();
                for (int i = 0; i < numLength; i++) {
                    newList.insertItem(new ItemType(scanner.nextInt()));
                }
                System.out.print("The list 1: ");
                list.printList();
                System.out.print("The list 2: ");
                newList.printList();
                System.out.print("Intersection of lists: ");
                SortedLinkedList intersectionList = list.intersection(list, newList);
                intersectionList.printList();
                scanner.nextLine();
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
