import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Shikhar on 25-03-2018.
 */
public class CalculateSubStrings {

    static Set<String> setOfSubStrings=new TreeSet<>();;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String testSample=scanner.nextLine();
        int lengthOfString=testSample.length();
        int beginIndexOfString=0;
        generateAndPrintSubString(testSample,beginIndexOfString,lengthOfString);
        setOfSubStrings.forEach(System.out::println);
        System.out.print("Number of substrings present are :-"+ (long) setOfSubStrings.size());
    }

    private static Set<String> generateAndPrintSubString(String testSample,int beginIndexOfString,int endIndexOfString) {

        int length = testSample.length();
        if(beginIndexOfString >=length)
            return setOfSubStrings;

        System.out.println("beginIndexOfString is : {" +beginIndexOfString+"}"+" & endIndexOfString is: {"+endIndexOfString+"}");
        if(beginIndexOfString==endIndexOfString) {
            beginIndexOfString++;
            endIndexOfString=length;
        }

        String calculatedSubstring = testSample.substring(beginIndexOfString, endIndexOfString);
        System.out.println("Calculated subString is : {"+calculatedSubstring+"}");
        System.out.println("---------- --------- --------- ---------");
        setOfSubStrings.add(calculatedSubstring);
        return generateAndPrintSubString(testSample,beginIndexOfString,endIndexOfString-1);
    }
}
