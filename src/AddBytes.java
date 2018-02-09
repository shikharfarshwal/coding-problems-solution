/**
 * Created by Shikhar on 22-12-2017.
 */
public class AddBytes extends CountDuplicate {

    private static byte a = 1;
    private byte b = 2;

    //byte c=a+b;//compilation error
    Integer a1 = new Integer(1);
    Integer b1 = new Integer(2);

    int c1 = a1 + b1;

    public  void methodFromSubClass() {
        System.out.println("in subclass method");
    }

    public static void main(String[] args) {
        long l = Long.parseLong(String.valueOf(a));
        System.out.println(l);
        CountDuplicate countDuplicate = new AddBytes();
        AddBytes addBytes= (AddBytes) countDuplicate;
        addBytes.methodFromSubClass();
        //countDuplicate.methodFromSubClass();
    }

    /**
     * Compilation Error you cant add Integer objects although you can add the primitive types
     */
    /* if(a1!=b1){

    }*/

}
