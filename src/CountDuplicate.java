import java.util.*;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 11-01-2018.
 */
public class CountDuplicate {


    public static void main(String[] args) {

        int[] arrayOfPrimitiveDuplicates=new int[]{};

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

        // using JAVA 8 sort a MAP
        List<Map.Entry<Integer, Long>> collect = PRIMITIVE_MAP_COLLECT.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        System.out.println("JAVA 8 key with max occurence is : "+collect.get(0).getKey());

        PRIMITIVE_MAP_COLLECT.entrySet().forEach(System.out::println);

        System.out.println("Using JAVA 7 ");

        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i = 0; i <= arrayOfPrimitiveDuplicates.length - 1; i++) {
            int toBeCounted = arrayOfPrimitiveDuplicates[i];
            int count=0;
            for (int j = 0; j <= arrayOfPrimitiveDuplicates.length - 1; j++) {
                if(toBeCounted==arrayOfPrimitiveDuplicates[j]){
                    count++;
                    countMap.put(toBeCounted,count);
                }
            }
            count=0;
        }


        List<Map.Entry<Integer,Integer>>  list=new LinkedList<>(countMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        /**
         * The key with maximum value is
         */
        System.out.println("JAVA 7 the key with max entry is : "+list.get(0).getKey());

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.entrySet().forEach(System.out::println);

    }
}
