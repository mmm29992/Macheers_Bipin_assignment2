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

    public void insertItem( T item) 
    {
        NodeType<T> newNode = new NodeType<>();
        NodeType<T> temp = head;
        newNode.info = item;

        // if list is empty
        if (head == null) 
        {
            head = newNode;
        } else if (newNode.info.compareTo(head.info) < 0)   // insert at the beginning 
        {
            newNode.next = head;
            head.back = newNode;
            head = newNode;
        } else  // insert in the midd
        {
while (item.compareTo(temp.info) > 0)
{
    if (temp.next != null) {
        temp = temp.next;
    } else
        break;
}
if ( temp.next == null && newNode.info.compareTo(temp.info) > 0)
{
    temp.next = newNode;
    newNode.back = temp;
} else 
{
    NodeType<T> back = temp.back;
    newNode.next = temp;
    temp.back = newNode;
    newNode.back = back;
    back.next = newNode;
}

        }

       
        


    }

}
