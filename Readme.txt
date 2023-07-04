# Macheers_Bipin_assignment2

 Bipasha Bipin (bb84832@uga.edu)
 Michael Macheers (mmm29992@uga.edu)

 compile and run instructions: 

 run script: $ ./script2.sh
 only runs the int text file. You will have to switch the file to run with the double and string text files. 


In the readme file give the pseudo code (steps) for your deleteSubsection operation. Using this
pseudocode, explain the complexity (big O) of your deleteSubsection operation.

    deleteSubsection():
    *First a new node is created
    *Node points to head called 'temp'
    *While loop begins
    *Inside while condtion, continues as long as temp is not equal to null
    *If block begins with condition to find if the value contained in temp
    compared to the lower range parameter is greater than or equal to 0 or if the value contained in temp
    compared to the upper range provided parameter is greater than or equal to 0.
    *If this condition is passed, then the deleteItem method is called and deletes the value.
    *the temp is moved  to the next node

    Big O- O(n^2)


In the readme file give the pseudo code (steps) for your reverseList operation. Using this
pseudocode, explain the complexity (big O) of your reverseList operation.

    reverseList():
    *The program returns if the head is equal to null
    *First a new node is created called prev which is set to null
    *New node nex which is set to the next node after head
    *The node that is created is called prev that is initialized to null
    *While loop begins
    *Inside while condition, continues as long as head is not equal to null
    *The next node after head is pointing to the new node that was created, prev
    *The node behind head is pointing to the variable nex
    *prev node is pointing to head
    *head is pointing to the next head

    Big O- O(n)

In the readme file give the pseudo code (steps) for your swapAlt operation. Using this
pseudocode, explain the complexity (big O) of your swapAlt operation.

      swapAlt():
      *We first check if the list is either of length 0, 1, or 2.
      *Returns if that condition is valid
      *While loop begins
      *Inside the condition, head and head.next cannot equal null
      *while the condition applies, we create three new Nodes as pointers:
      *nex which is set to the head.next
      *prev which is set to head.back
      *twoNex which is two nodes ahead of head
      *then we begin swapping:
      *head.next points to nex.next
      *head.back points to nex
      *however, if prev doesn't equal to null, then prev.next will point to nex
      *else head will be nex.next
      *nex.next will point to head
      *nex.back will point tp prev
      *if twoNex does not equal null, then twoNex.back is set to head
      *head is then set to twoNex

      Big O- O(n)
