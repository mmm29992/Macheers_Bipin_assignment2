import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * DoublyLinkedListDriver class.
 */
public class MichaelDriver<T extends Comparable<T>> {
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

    public static final char INT = 'I';
    public static final char DOUBLE = 'D';
    public static final char STRING = 'S';

    /**
     * Start of main method.
     */
    public static void main(String[] args) {

        // Check if a command-line argument was provided
        if (args.length > 0) 
        {
            String filename = args[0]; // Get the filename from the first command-line argument
            Scanner scanner = new Scanner(System.in);
            // creating the scanner to read the file
            Scanner scanFile = null;
            try 
            {
                File listFile = new File(filename);
                scanFile = new Scanner(listFile);
            } catch (FileNotFoundException e) 
            {
                System.out.println("File not found: " + filename);
                return;
            }

            // prompt the user for the data type of the list
            System.out.print("Enter list type (I - int, D - double, S - string): ");
            Scanner inputScanner = new Scanner(System.in);
            String dataType = inputScanner.nextLine();

            String inputCommand = "";
            while (!inputCommand.equals("" + QUIT)) 
            {
                boolean correctCommand = true;
                switch (dataType) {
                    case "" + INT:
                        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
                        while (scanFile.hasNext()) {
                            int fileItems = scanFile.nextInt();
                            list.insertItem(fileItems);
                            

                        }
                        switch (inputCommand) {
                            case "" + PRINT:
                                System.out.print("The list is: ");
                                list.print();
                                break;
                                
                            case "" + PRINT_REV:
                                System.out.print("The reverse list: ");
                                list.printReverse();
                            
                        }
                        break;

                }
                if (correctCommand)
                {
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
                } else 
                {
                    System.out.print("Invalid command try again: ");
                }
                inputCommand = scanner.nextLine();
                if (inputCommand.equals("" + QUIT)) 
                {
                    System.out.println("Exiting the program...");
                }
            }

        }
    }
}