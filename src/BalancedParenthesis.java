import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Shikhar on 08-04-2018.
 */
public class BalancedParenthesis {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        if(checkBalancedParenthesis(input.toCharArray())){
            System.out.println("YES");
        }
        else
            System.out.println("NO");

    }

    private static boolean checkBalancedParenthesis(char[] chars) {
        Stack<Character> stack=new Stack<>();

        for (int i=0;i<=chars.length-1;i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }

            if(chars[i] == ')' || chars[i] == ']' || chars[i] == '}'){
                if (stack.isEmpty())
                {
                    return false;
                }
                Character pop = stack.pop();
                if(!isMatchingParenthesis(pop,chars[i])){
                    return false;
                }
            }

        }
        if (stack.isEmpty())
            return true; /*balanced*/
        else
        {   /*not balanced*/
            return false;
        }
    }

    private static Boolean isMatchingParenthesis(char poppedCharacter,char expressionChar) {
        return poppedCharacter == '(' && expressionChar == ')'
                || poppedCharacter == '[' && expressionChar == ']'
                || poppedCharacter == '{' && expressionChar == '}';
    }
}
