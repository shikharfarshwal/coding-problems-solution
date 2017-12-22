/**
 * Finds the first palindrome no between 20 & 90
 */
public class FirstPalindrome {
    private static int count=0;
    public static void main(String[] args) {
        Integer start;
        int end=90;

        for(start=20;start<=end;start++){
            //Integer checkPalindrome = checkPalindrome(start);
            Integer checkPalindrome=checkPalindromeUsingStringBuffer(start);
            if(checkPalindrome!=null){
                System.out.println("First palindrome between 20 & 90 is"+checkPalindrome);
            }
        }


    }

    private static Integer checkPalindromeUsingStringBuffer(Integer start) {
        StringBuffer buff=new StringBuffer(start.toString());
        String reversed = buff.reverse().toString();

        if(reversed.equalsIgnoreCase(start.toString()) && count==0){
            count++;
            return Integer.parseInt(reversed);
        }
        return null;
    }


    private static Integer checkPalindrome(Integer start){
        String startPalindrome = start.toString();
        char[] chars = startPalindrome.toCharArray();

        String reversedNo="";
        for(int i=startPalindrome.length()-1;i>=0;i--){
            reversedNo=reversedNo+chars[i];
        }

        if(reversedNo.equalsIgnoreCase(startPalindrome) && count==0){
            count++;
            return Integer.parseInt(reversedNo);
        }
        return null;
    }
}
