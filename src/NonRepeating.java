import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Created by Shikhar on 05-01-2018.
 */
public class NonRepeating {

    public static void main(String[] args) {
        testLogic();
    }

    private static void testLogic() {
        String toBeEvaluated="hellohellos";
        /*Map<Integer, Long> collect = toBeEvaluated.chars().boxed().
                collect(Collectors.groupingBy(x->x.intValue(), Collectors.counting()));*/

        Map<String, Long> collectedUsingSplit = Stream.of(toBeEvaluated.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collectedUsingSplit.entrySet().stream().forEach(System.out::println);

    }
}
