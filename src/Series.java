import java.util.Scanner;

/**Print the below series
 *
 *     #
 ##
 ###
 ####
 #####
 */
public class Series {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        for(int i = 0; i<=n-1;i++){

            for(int j=n-1 ;j>i;j--){
                System.out.print(" ");
            }
            for(int j=0 ;j<=i;j++){
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
