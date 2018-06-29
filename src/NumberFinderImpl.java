import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Shikhar on 29-05-2018.
 */
public class NumberFinderImpl /*implements NumberFinder*/ {

    public static void main(String[] args) {
        int size, i;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Array Size 1: ");
        size = scan.nextInt();
        int array1[] = new int[size];
        System.out.print("Enter Array Elements : ");
        for (i = 0; i < size; i++) {
            array1[i] = scan.nextInt();
        }
        System.out.print("Enter Array Size 2: ");
        size = scan.nextInt();
        int array2[] = new int[size];
        System.out.print("Enter Array Elements : ");
        for (i = 0; i < size; i++) {
            array2[i] = scan.nextInt();
        }

        Set<Integer> setOfElements = new HashSet<>();
        if(array2.length>array1.length){
            populateSet(array2, setOfElements);
            performComparisoin(array1,setOfElements);
        }
        else {
            populateSet(array1, setOfElements);
            performComparisoin(array2,setOfElements);
        }

        System.out.println("The extra element are");
        Iterator<Integer> iterator = setOfElements.iterator();
        while (iterator.hasNext()){
          //  retrun iterator.next();
        }
        setOfElements.forEach(System.out::println);

    }

    private static void populateSet(int[] array1, Set<Integer> setOfElements) {
        for (int value :
                array1) {
            setOfElements.add(value);
        }
    }

    private static void performComparisoin(int[] array, Set<Integer> setOfElements) {
        for(int j=0 ;j<=array.length-1;j++){
            if(setOfElements.contains(array[j])){
             setOfElements.remove(array[j]);
            }
        }
    }
}
