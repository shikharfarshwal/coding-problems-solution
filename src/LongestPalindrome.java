import java.util.*;

/**
 * Created by Shikhar on 08-04-2018.
 */
public class LongestPalindrome {
    private static Map<Integer,String> mapOfSubStrings=new TreeMap<>(Comparator.comparing(Integer::intValue).reversed());
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String testSample=scanner.nextLine();
        int lengthOfString=testSample.length();
        int beginIndexOfString=0;
        CalculateSubStrings.generateAndPrintSubString(testSample,beginIndexOfString,lengthOfString);

        CalculateSubStrings.setOfSubStrings.forEach(p->{
            boolean isPalindrome = CheckForPalindrome(p);
            if(isPalindrome){
                mapOfSubStrings.put(p.length(),p);
            }
        });
        mapOfSubStrings.entrySet().stream().findFirst().ifPresent(System.out::println);
    }

    private static boolean CheckForPalindrome(String stringToCheck) {
        StringBuilder stringBuilder=new StringBuilder(stringToCheck);
        stringBuilder.reverse();
        return stringBuilder.toString().equalsIgnoreCase(stringToCheck);
    }


}
