import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 24-11-2018.
 */
public class TestImmu {


    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        String stringOfNumbers = sc.nextLine();
        String[] arrayOfNumbers = stringOfNumbers.split(" ");
        int sum=Integer.MIN_VALUE;
        Stream<Integer> boxed = Arrays.stream(arrayOfNumbers).mapToInt(Integer::parseInt).boxed();


        boxed.forEach(System.out::println);

        /*for(int i=0;i<=arrayOfNumbers.length-1;i++){
            int j=arrayOfNumbers.length-1;
            int mid=(i+j)/2 ;
            calculateSum(arrayOfNumbers,i,mid);
            calculateSum(arrayOfNumbers,mid+1,j);
        }
   */ }

/*    public static int calculateSum(String[] arrayOfNumbers,int begin,int last) {

        int mid=(begin+last)/2;
        if(begin != last){
        return calculateSum(arrayOfNumbers,begin,mid);
        }
        else{
        Stack<Integer> stack= new Stack<>();
        stack.push(Integer.parseInt(arrayOfNumbers[begin]));
        }



    }*/
}
