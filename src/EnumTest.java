import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shikhar on 08-02-2018.
 */
public class EnumTest {

    public static void main(String[] args) {
        List<? extends Number> test=new ArrayList<Number>();
        List<? extends Number> test1=new ArrayList<Integer>();

        List<? extends Number> test2=new ArrayList<Double>();
        System.out.println(Barcode.b);
    }

    enum Barcode{
        a,b,c,d,e;
    }
}
