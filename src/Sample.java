/**
 * Created by Shikhar on 08-02-2018.
 */
public class Sample {

    private int Value=5;

    public int getValue(){
        return this.Value;
    }

    public int getValue(int value){
        return (Value+2);
    }

    public int getValue(int ... value){

        return ( value[0]+3);
    }


    public static void main(String... args) {
        Sample temp=new Sample();
        //args[0]="sdadaf";
        System.out.println(temp.getValue(6,9,13));
    }
}
