package leetCode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Shikhar on 22-03-2019.
 */
public class LongestPalindromicSubstring {

    /**
     * My 1st Naive Approach O(n2) Time and space complexity.
     * Sliding window approach
     *
     * @param s
     * @return
     */
    private String longestPalindrome(String s) {
        int i = 0, j = 0;
        String answer = "";
        char[] charArray = s.toCharArray();
      /*  Set<String> ans = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(),o1.length());
            }
        });*/
        int len = s.length();
        String subS = "";
        if (s.isEmpty()) {
            return answer;
        }
        while (i < len) {
            if (j > len - 1) {
                i++;
                j = i;
                subS = "";
            }
            if (i == len - 1 && j == len - 1) {
                subS = subS.intern() + charArray[j];
                i++;
            } else {
                subS = subS.intern() + charArray[j++];
            }
            if (isPalindrome(subS)) {
                if (Integer.compare(answer.length(), subS.length()) == -1) {
                    answer = subS;
                }
                //ans.add(subS);
            }
        }
        //return ans.stream().findFirst().get();
        return answer;
    }

    /**
     * DP solution.
     *
     * @param s
     * @return
     */

    public String dpSolution(String s) {
        int len = s.length();
        String palindrome="";
        int palindromeLength = 0;

        boolean[][] cache = new boolean[len][len];
        //for length =1
        for (int i = 0; i < len; i++) {
            cache[i][i] = true;
            if (s.substring(i, i+1).length() > palindromeLength) {
                palindrome = s.substring(i, i+1);
                palindromeLength = palindrome.length();
            }
        }
        //for length =2
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cache[i][i + 1] = true;
                int j =i+2;
                if (s.substring(i, j).length() > palindromeLength) {
                    palindrome = s.substring(i, j);
                    palindromeLength = palindrome.length();
                }
            }
        }
        //for length > 2
        for( int k = 3 ; k<=len;k++){
            for(int i=0;i<len-k+1;i++){ // k+1 is done as coz i should be less then k always not greater then that otherwise string out of bounds exception
                int j = i+k-1; // we need k-1 to avoid string out of bounds exception which occurs coz j will be 0+3 = 3
                if(s.charAt(i) == s.charAt(j) && cache[i+1][j-1]){
                    cache[i][j]=true;
                    if(s.substring(i,j+1).length() > palindromeLength){
                        palindrome = s.substring(i,j+1);
                        palindromeLength=palindrome.length();
                    }
                }
            }
        }

        return palindrome;
    }


    private boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return s.equalsIgnoreCase(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lPSub = new LongestPalindromicSubstring();
        //System.out.println(lPSub.longestPalindrome("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
        //System.out.println(lPSub.dpSolution("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
        //System.out.println(lPSub.dpSolution("cbbd"));
        System.out.println(lPSub.dpSolution("bbbb"));
    }
}
