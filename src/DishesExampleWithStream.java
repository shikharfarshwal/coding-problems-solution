import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Shikhar on 04-01-2018.
 */
public class DishesExampleWithStream {
    static List<Dish> menu;
    static List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 0, 9);
    static List<Integer> numbers2 = Arrays.asList(3, 4);

    public void getChar() {

        numbers.stream().reduce((a, b) -> a > b ? a : b).ifPresent(System.out::println);

        words.stream().map(String::length)
                .collect(toList());

        Stream<String[]> streamOfWords = words.stream().map(p -> p.split(""));
        List<String[]> collect = streamOfWords
                .distinct()
                .collect(Collectors.toList());
        List<String> collect1 = streamOfWords
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

    }

    public static void main(String[] args) {
        populateDish();

        String hello = words.stream()
                .reduce("This is ", (a, b) -> a.concat(b));
        System.out.println("concat string is " + hello);

        menu.stream().
                map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        numbers.stream().reduce((a, b) -> a < b ? a : b).ifPresent(System.out::println);

        List<Integer> collect2 = numbers.stream()
                .map(p -> p * p)
                .collect(toList());
        //System.out.println(collect2);
/**
 * Given two arrays [1,2,3] & [4,5,6] result should be [(1,2),(1,4)......]
 */
        List<int[]> collect = numbers.stream().flatMap(n1 -> numbers2.stream()
                .filter(n2 -> (n1 + n2) % 3 == 0)
                .map(n2 -> new int[]{n1, n2})).collect(toList());

        // System.out.println(collect);

        List<String> threeHighCaloricDishName = menu.stream().filter(p -> p.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());

        List<Dish> collectMeat = menu.stream().filter(p -> p.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());
        // System.out.println(collectMeat);

        long count = menu.stream().filter(p -> p.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .count();

        //System.out.println(count);
        //System.out.println(threeHighCaloricDishName);
    }

    private static void populateDish() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


    }
}
