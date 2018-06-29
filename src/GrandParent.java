/**
 * Created by Shikhar on 11-02-2018.
 */
public class GrandParent {

    public GrandParent abc(){
        System.out.println("In grand parent");
        return new GrandParent();
    }

    static final void get(){
        System.out.println("gran d parent");
    }
}
