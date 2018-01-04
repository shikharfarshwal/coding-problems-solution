import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Shikhar on 04-01-2018.
 */
public class TestTrader {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        /**
         * @question
         * Find all transactions in 2011 and sort by value (small to high)
         */
        List<Transaction> transactionList2011Sorted = transactions.stream()
                //.map(Transaction::getYear)
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
        System.out.println(transactionList2011Sorted);


        /**
         * @question
         * What are all the unique cities where the traders work?
         */

        List<String> uniqueCitiesOfTraders = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct().collect(toList());
        System.out.println(uniqueCitiesOfTraders);

        /**
         * @question
         * Find all traders from Cambridge and sort them by name
         */

        Stream<Transaction> tradersFromCambridge = transactions.stream()
                .filter((t) -> t.getTrader().getCity().equalsIgnoreCase("cambridge"));
        List<Transaction> sortedTradersFromCambridge = tradersFromCambridge
                .sorted(Comparator.comparing(t -> t.getTrader().getName())).collect(toList());
        System.out.println(sortedTradersFromCambridge);

        /**
         * @question
         * Return a string of all traders’ names sorted alphabetically
         */

        String sorted_name_all_traders = transactions.stream()
                .map(a -> a.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a.concat(b));//or String::concat by method reference
        System.out.println(sorted_name_all_traders);

        /**
         * @question
         * Are any traders based in Milan?
         */
        boolean isAnyTraderFromMilan = transactions.stream()
                .anyMatch(t -> t.getTrader()
                        .getCity()
                        .equalsIgnoreCase("milan"));
        System.out.println("is trader from milan " +isAnyTraderFromMilan);

        /**
         * @question
         * Print all transactions values from the traders living in Cambridge
         */
        transactions.stream()
                .filter(t->t.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println("------------Next question number 07 answer is-------------");
        /**
         * @question
         * What’s the highest value of all the transactions?
         */
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
        System.out.println("------------Next question number 08 answer is-------------");
        /**
         * @question
         * Find the transaction with the smallest value
         */
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }

}
