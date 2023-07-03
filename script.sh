
#!/bin/bash
javac NodeType.java
javac -cp .:NodeType.class DoublyLinkedList.java
javac -cp .:NodeType.class:DoublyLinkedList.class DoublyLinkedListDriver.java
java DoublyLinkedListDriver int-input.txt
