import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 11-01-2018.
 */
public class CountDuplicate {


    public static void main(String[] args) {

        int[] arrayOfPrimitiveDuplicates=new int[]{1,2,1,3,4,1,2,1,5,3,5};

        List<Integer> arrayOfDuplicates=new ArrayList<>();
        arrayOfDuplicates.add(1);
        arrayOfDuplicates.add(3);
        arrayOfDuplicates.add(2);
        arrayOfDuplicates.add(3);
        arrayOfDuplicates.add(1);
        arrayOfDuplicates.add(2);

        /**
         *  ANSWER 1 USING LIST
         */
        HashMap<Integer, Long> LIST_MAP = arrayOfDuplicates.stream().
                collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        /**
         *  ANSWER 2 USING LIST
         */
        Map<Integer, Long> mapOfDuplicates = arrayOfDuplicates.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        /**
         *  ANSWER 3 USING primitive array
         */
        Map<Integer, Long> PRIMITIVE_MAP_COLLECT = Stream.of(arrayOfPrimitiveDuplicates)
                .flatMapToInt(x -> Arrays.stream(x))//can be replaced woth method reference Arrays::stream
                .boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //mapOfDuplicates.entrySet().forEach(System.out::println);
        PRIMITIVE_MAP_COLLECT.entrySet().forEach(System.out::println);
    }
}
