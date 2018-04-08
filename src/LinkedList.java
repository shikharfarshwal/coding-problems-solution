import sun.awt.image.ImageWatched;

/**
 * Created by Shikhar on 17-02-2018.
 */
public class LinkedList {
    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head.value +
                '}';
    }

    Node head;
    static LinkedList linkedList=new LinkedList();
    public static void main(String[] args) throws CloneNotSupportedException {
        Node node1=new Node("1");
        Node node2=new Node("2");
        Node node3=new Node("3");
        Node node4=new Node("4");
        linkedList.head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
    //checkForPalindrome(linkedList);
        //pushAtFirst(linkedList);
        //pushAfterANode(node1,"11.5");
        //traverseLinkListAndPushNewNode(linkedList);
      //  printList(linkedList);
       // System.out.println("----------Delete a node-----------");
        //deleteANode("11.5",linkedList);
        reverseLinkList(linkedList);
        //printList(linkedList);
    }

    private static void checkForPalindrome(LinkedList linkedList) {
        StringBuilder stringBuilder=new StringBuilder();
        Node head = linkedList.head;
        while (head!=null){
            stringBuilder.append(head.value);
            head=head.next;
        }
        System.out.println("stringbuffer  is "+stringBuilder);
        String original=stringBuilder.toString();
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println("reverse is"+ reverse);
        if(original.equals(reverse.toString()))
            System.out.println("linkedlist is palindrome");
        else
            System.out.println("not palindrome");
    }

    private static void traverseLinkListAndPushNewNode(LinkedList linkedList){
        Node new_node=new Node("14");
       Node last=linkedList.head;
        while (last.next!=null){
            last=last.next;
        }
        last.next=new_node;
       new_node.next=null;

    }

    static LinkedList printList(LinkedList linkedList){
        while (linkedList.head!=null){
            System.out.println(linkedList.head.value);
            linkedList.head=linkedList.head.next;
        }
        return linkedList;
    }

    static void pushAtFirst(LinkedList linkedList){
        Node node3=new Node("10");
        node3.next=linkedList.head;
        linkedList.head=node3;
    }

    static void pushAfterANode(Node prevNode,String data){
        Node new_node=new Node(data);
        new_node.next=prevNode.next;
        prevNode.next=new_node;
    }

    static void deleteANode(String nodeToBeDeleted,LinkedList linkedList){
        Node traversedHead = linkedList.head;
        Node prev=null;
        int count=0;
        if(traversedHead!=null && traversedHead.value==nodeToBeDeleted){
            linkedList.head=traversedHead.next;
            return;
        }
        while (traversedHead.next!=null && !nodeToBeDeleted.equalsIgnoreCase(traversedHead.value)){
                    prev= traversedHead;
                    traversedHead=traversedHead.next;
            }
            if(traversedHead==null) return;
            prev.next=traversedHead.next;
        }


        static void reverseLinkList(LinkedList linkedList) throws CloneNotSupportedException {
            Node current = linkedList.head;
            System.out.println("current is "+current);
            Node prev=null;
            Node next=null;
            while (current!=null){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            linkedList.head=prev;
        }
}
