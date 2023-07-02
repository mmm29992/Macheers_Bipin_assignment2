import java.util.NoSuchElementException;

import NodeType;

public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    /**
     * Constructs an empty DoublyLinkedList
     * The constructor initializes the head of the list to null, indicating an empty
     * list.
     * This constructor is used to create a new instance of the DoublyLinkedList
     * class.
     * The head variable will be updated when elements are added to the list.
     * 
     * @param <T> the type of elements held in this DoublyLinkedlist
     */
    DoublyLinkedList() {
        head = null;
    }

    /**
     * Inserts an item into the linked list in its sorted position.
     * 
     * @param item the item to be inserted 
     */
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>();
        NodeType<T> temp = head;
        newNode.info = item;

        // if list is empty
        if (head == null) {
            head = newNode;
        } else if (newNode.info.compareTo(head.info) < 0) // insert at the beginning 
        {
            newNode.next = head;
            head.back = newNode;
            head = newNode;
        } else // insert in the midd
        {
            while (item.compareTo(temp.info) > 0) {
                if (temp.next != null) {
                    temp = temp.next;
                } else
                    break;
            }
            if (temp.next == null && newNode.info.compareTo(temp.info) > 0) {
                temp.next = newNode;
                newNode.back = temp;
            } else {
                NodeType<T> back = temp.back;
                newNode.next = temp;
                temp.back = newNode;
                newNode.back = back;
                back.next = newNode;
            }

        }

    }

    /**
     * Deletes the specified item from the linked list 
     * 
     * @param item the item to be deleted 
     * @throws NoSuchElementException if the item is not found in the linked list.
     */
    public void deleteItem(T item) 
    {
        NodeType<T> temp = searchItem(item);
      
        // deleteing the first item 
        if (temp.back == null) 
        {
            NodeType<T> front = temp.next;
            front.back = null;
            head = front; 
        } else if ( temp.next == null) // delete last item
        {
            NodeType<T> back = temp.back;
            back.next = null; 
        } else // delete in the middle
        {
            NodeType<T> front = temp.next;
            NodeType<T> back = temp.back;
            front.back = back;
            back.next = front; 
        }
    }

    /**
     * Searches for an item in the linked list
     * 
     * @param item the item is searcing for 
     * @return the node containing the item if found \
     * @throws NoSuchElementException if the item is not found in the linked list. 
     */
    public NodeType<T> searchItem(T item) 
    {
        NodeType<T> temp = head;
        if (temp.info.compareTo(item) != 0 && temp.next != null) {
            temp = temp.next;
        } else if ((temp.info.compareTo(item) != 0) && temp.next == null) {
            throw new NoSuchElementException("Item not found");
        } else {
            return temp;
        }
        return temp;
    }
    
    /**
     *  Returns the number of elements in the linked list
     * 
     * @return the number of elements in the linked list 
     */
    public int length() 
    {
        int count = 0;
        NodeType<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    /**
     * Prints the elements of the linked list to the console.
     * The elements are seperated by a spaced and are printed in the order
     * they appear in the list.
     * A line break is added after printing out all the elements. 
     */
    public void print()
    {
        NodeType<T> temp = head;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    /**
     * Prints the elements of the linked list in reverse order to the console.
     * The elements are seperated by a space and are printed in reverse order compared
     * to their original order in the list.
     * A line brealk is added after printing all the elements.
     */
    public void printReverse() 
    {
        NodeType<T> temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        while (temp != null) 
        {
            System.out.print(temp.info + " ");
            temp = temp.back;
        }
        System.out.println();
    }
}