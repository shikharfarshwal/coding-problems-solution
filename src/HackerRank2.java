import java.util.PriorityQueue;

/**
 * Created by Shikhar on 31-03-2019.
 */
public class HackerRank2 {
String s1;
String s2;
String s3;



}

class Hck extends HackerRank2{
    public static void main(String[] args) {
        PriorityQueue toDo = new PriorityQueue();
        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        toDo.offer("bills");


        try{

        }
        catch (Exception e){

        }
       // add(1,2);
        System.out.println(toDo.size()+" "+toDo.poll());
        System.out.println(toDo.peek()+" "+toDo.poll());
        System.out.println(toDo.poll()+" "+toDo.poll());
    }
}
