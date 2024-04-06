package com.old.code;

/**
 * Created by Shikhar on 22-12-2017.
 */
public class AddBytes extends CountDuplicate {

    private byte a = 1;
    private byte b = 2;

    public  void methodFromSubClass() {
        System.out.println("in subclass method");
    }




    public static void main(String[] args) {
        Integer b1 = new Integer(2);
        Integer a1 = new Integer(1);
        Integer c=b1+a1;
       /* long l = Long.parseLong(String.valueOf(a));
        System.out.println(l);
        CountDuplicate countDuplicate = new AddBytes();
        AddBytes addBytes= (AddBytes) countDuplicate;
        addBytes.methodFromSubClass();*/
        //countDuplicate.methodFromSubClass();
        if(a1!=b1){

        }
    }

    /**
     * Compilation Error you cant add Integer objects although you can add the primitive types
     */


}
