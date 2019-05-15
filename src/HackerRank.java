import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Shikhar on 31-03-2019.
 */
public class HackerRank {


    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

    public static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
        Set<Integer> visited = new HashSet<>();
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode prev = curr;

        while (curr.next != null) {

            if (visited.contains(curr.data)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                visited.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
        if (visited.contains(curr.data)) {
            prev.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

    }


}
