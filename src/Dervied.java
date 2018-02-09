import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Shikhar on 12-01-2018.
 */
public class Dervied extends Base {
static final int constants=1;
    protected String address;
 /*   Dervied(){
       // super("asdasd");

        System.out.println("Inside dervied class constructor");
    }*/

    Dervied(String address){
       // super("asdasd");
        System.out.println("dervied & address is "+address);
    }

    public static void main(String[] args) {
       // Dervied dervied=new Dervied("hello");
        Base base=new Dervied("hgfhg");

        Hashtable<Integer,String> integerStringHashtable=new Hashtable<>();
       // integerStringHashtable.put(null,"afad"); //throws null pointer exception
        HashMap<Integer,String> stringHashMap=new HashMap<>();
        stringHashMap.put(null,"dsfsdf");
        stringHashMap.put(null,"hgfgh");
        stringHashMap.entrySet().forEach(System.out::println);

        LinkedList<Integer> integers=new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1,5);

        TreeSet<Integer> integers1=new TreeSet<>();
        integers.add(1);
        integers.add(2);
    }
}
