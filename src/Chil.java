import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shikhar on 11-02-2018.
 */
public class Chil extends Parent
{

      public Chil abc(){
        System.out.println("In child");
        return new Chil();
    }

    static void inChild(){
        System.out.println("static method in child");
    }

    public static void main(String[] args) {
 /*       GrandParent chil=new Chil();
        System.out.println("-----GrandParent chil=new Chil()-----");
        chil.abc();
        GrandParent parent=new Parent();
        System.out.println("-----GrandParent parent=new Parent()-----");
        parent.abc();
        System.out.println("-----GrandParent grandParent=new GrandParent();-----");
        GrandParent grandParent=new GrandParent();
        grandParent.abc();*/
        System.out.println("-----Chil chil1=new Chil();-----");
       // Chil chil1=new Chil();
       // chil1.abc();
        //chil1.inChild();

        List<Integer> dummyList=new ArrayList<>();
        dummyList.add(1);
        dummyList.add(-2);
        dummyList.add(13);
        dummyList.add(-4);
        dummyList.add(5);

        for(int i=0;i<dummyList.size();i++){
            if(i<-1) {
                dummyList.remove(i);
            }
        }

        Parent parent=new Parent();
        parent.inParent();

        Parent parent1=new Chil();
        parent1.inParent();



    }
}
