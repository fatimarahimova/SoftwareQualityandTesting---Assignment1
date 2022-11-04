/* @Author
 * Doğukan Arslan
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 *
 */
package com.blg475e_2;

public class DoublyLinkedList {

    // Node of the doubly linked list
    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // Head and tail of the doubly linked list
    Node head, tail = null;

    // Default constructor for the class
    DoublyLinkedList() {};

    // Constructor with argument for the class
    DoublyLinkedList(String list) {
        String[] arrOfStr = list.split(" ");

        for (int i = 0; i < arrOfStr.length; i++) {
            int nodeData = Integer.parseInt(arrOfStr[i]);
            this.addNode(nodeData);
        }
    }

    // addNode() will add a node to end of the list
    public void addNode(int data) {
        // Create a new node
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            // Both head and tail will point to newNode
            head = tail = newNode;
            // head's previous will point to null
            head.previous = null;
        }
        else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode's previous will point to tail
            newNode.previous = tail;
            // newNode will become new tail
            tail = newNode;
        }
        // tail's next will point to null, as it is the last node of the list
        tail.next = null;
    }

    // countNodes() will count the nodes present in the list
    public int countNodes() {
        int counter = 0;
        // Node current will point to head
        Node current = head;

        while (current != null) {
            // Increment the counter by 1 for each node
            counter++;
            current = current.next;
        }
        return counter;
    }

    // getList() will return the elements of the list
    public String getList() {
        // list string will include all elements of the list as a string
        String list = "";
        // Node current will point to head
        Node current = head;
        if (head == null) {
            return list;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            // Prints each node by incrementing the pointer.
            list += current.data + " ";
            current = current.next;
        }

        // trim function removes last space
        return list.trim();
    }

    // getNode() will return the value of the specified node
    public int getNode(int index) {
        // Node current will point to head
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // reverse() will reverse the doubly linked list
    public void reverse() {
        // Node current will point to head
        Node current = head, temp = null;

        // Swap the previous and next pointers of each node to reverse the direction of the list
        while (current != null) {
            temp = current.next;
            current.next = current.previous;
            current.previous = temp;
            current = current.previous;
        }
        // Swap the head and tail pointers.
        temp = head;
        head = tail;
        tail = temp;

        return;
    }

    // deleteFromBeginning() will delete a node from the beginning of the list
    public void deleteFromBeginning() {
        // Checks whether list is empty
        if(head == null) {
            return;
        }
        else {
            // Checks whether the list contains only one element
            if (head != tail) {
                // head will point to next node in the list
                head = head.next;
                // Previous node to current head will be made null
                head.previous = null;
            }
            // If the list contains only one element
            // then, it will remove node and now both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    // deleteFromEnd() will delete a node from the end of the list
    public void deleteFromEnd() {
        // Checks whether list is empty
        if (head == null) {
            return;
        }
        else {
            // Checks whether the list contains only one node
            if (head != tail) {
                // Previous node to the tail will become new tail
                tail = tail.previous;
                // Node next to current tail will be made null
                tail.next = null;
            }
            // If the list contains only one element
            // Then it will remove node and now both head and tail will point to null
            else {
                head = tail = null;
            }
        }
    }

    // deleteFromMiddle() will delete a node from middle of the list
    public void deleteFromMiddle() {
        // Checks whether list is empty
        if(head == null) {
            return;
        }
        else {
            // current will point to head
            Node current = head;

            // Store the mid position of the list
            int size = countNodes();
            int mid = (size % 2 == 0) ? (size/2) : ((size+1)/2);

            // Iterate through list till current points to mid position
            for (int i = 1; i < mid; i++){
                current = current.next;
            }

            // If middle node is head of the list
            if (current == head) {
                head = current.next;
            }
            // If middle node is tail of the list
            else if (current == tail) {
                tail = tail.previous;
            }
            else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            // Delete the middle node
            current = null;
        }
    }

    // minimumNode() will find out minimum value node in the list
    public int minimumNode() {
        // Node current will point to head
        Node current = head;
        int min;

        // Checks if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
        else {
            //Initially, min will store the value of head's data
            min = head.data;
            while (current != null) {
                // If the value of min is greater than the current's data
                // Then, replace the value of min with current node's data

                if (min > current.data)
                    min = current.data;

                current = current.next;
            }
        }
        return min;
    }

    // maximumNode() will find out maximum value node in the list
    public int maximumNode() {
        // Node current will point to head
        Node current = head;
        int max;

        // Checks if list is empty
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
        else {
            // Initially, max will store the value of head's data
            max = head.data;
            // If value of max is lesser than current's data
            // Then, replace value of max with current node's data
            while(current != null) {
                if (current.data > max)
                    max = current.data;

                current = current.next;
            }
        }
        return max;
    }

    // removeDuplicateNode() will remove duplicate nodes from the list
    public void removeDuplicateNode() {
        // Node current will point to head
        Node current, index, temp;

        // Checks whether list is empty
        if(head == null) {
            return;
        }
        else {
            // Initially, current will point to head node
            for (current = head; current != null; current = current.next) {
                // index will point to node next to current
                for (index = current.next; index != null; index = index.next) {
                    if (current.data == index.data) {
                        // Store the duplicate node in temp
                        temp = index;
                        // index's previous node will point to node next to index thus, removes the duplicate node
                        index.previous.next = index.next;
                        if (index.next != null)
                            index.next.previous = index.previous;
                        // Delete duplicate node by making temp to null
                        temp = null;
                    }
                }
            }
        }
    }
    // TODO return sorted list
    // sortList() will sort the given list in ascending order
    public void sortList() {
        Node current = null, index = null;
        int temp;
        // Check whether list is empty
        if(head == null) {
            return;
        }
        else {
            // Current will point to head
            for (current = head; current.next != null; current = current.next) {
                // Index will point to node next to current
                for (index = current.next; index != null; index = index.next) {
                    // If current's data is greater than index's data, swap the data of current and index
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }

}
