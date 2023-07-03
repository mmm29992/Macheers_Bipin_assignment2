
#!/bin/bash
javac NodeType.java
javac -cp .:NodeType.class DoublyLinkedList.java
javac -cp .:NodeType.class:DoublyLinkedList.class MichaelDriver.java
java MichaelDriver int-input.txt
