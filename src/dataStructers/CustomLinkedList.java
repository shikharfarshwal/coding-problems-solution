package dataStructers;

/**
 * Created by Shikhar on 03-02-2019.
 */
public class CustomLinkedList {
    private Node head;
    private Node tail;
    int length;

    CustomLinkedList(String value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    /**
     * This function will append a new node to a linked list without using tail.
     *
     * @param value
     */
    public CustomLinkedList append(String value) {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        this.length++;
        this.tail = null;
        return this;
    }

    /**
     * Much better approach by using tail as a pointer to append.
     *
     * @param value
     */
    public CustomLinkedList appendUsingTail(String value) {
        Node nextNode = new Node(value);
        Node tail = this.tail;
        tail.next = nextNode;
        this.length++;
        this.tail = nextNode;
        return this;
    }

    /**
     * This function prePends before the first item of the linkedList.
     *
     * @param value
     * @return
     */
    public CustomLinkedList prePend(String value) {
        Node current = this.head;
        Node newNode = new Node(value);
        newNode.next = current;
        this.head = newNode;
        this.length++;
        return this;
    }

    /**
     * Insert a new Node based upon an index provided
     * Before Insert
     * 2-->5-->9-->10
     * After Insert at index 2 value 11
     * 2-->5-->11-->9-->10
     *
     * @param index
     * @param value
     * @return
     */
    CustomLinkedList insert(int index, String value) {
        Node currentNode = this.head;
        Node prevNode = currentNode;
        int i = 1;
        while (currentNode.next != null) {
            if (i == index) {
                System.out.println("Index matched "+i);
                Node newNode = new Node(value);
                newNode.next = currentNode;
                prevNode.next = newNode;
                break;
            }
            System.out.println("Index not matched "+i);
            prevNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }
        return this;
    }

    private class Node {
        String value;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public String toString() {
        return "dataStructers.CustomLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList("2");
        CustomLinkedList customLinkedList2 = new CustomLinkedList("2");
        System.out.println("Below is without using tail functionality");
        customLinkedList.append("3");
        System.out.println(customLinkedList.append("4"));
        /*System.out.println("Below is with using tail functionality");
        customLinkedList2.appendUsingTail("3");
        System.out.println(customLinkedList2.appendUsingTail("4"));*/
       // System.out.println("PrePends Starts");
        //System.out.println(customLinkedList.prePend("11"));
        System.out.println("Insert a new Node");
        System.out.println(customLinkedList.insert(2,"99"));
    }
}


