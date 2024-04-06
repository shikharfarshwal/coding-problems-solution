package com.old.code;

/**
 * Created by Shikhar on 11-02-2018.
 */
public class Parent extends GrandParent{

    public Parent abc(){
        System.out.println("In parent");
        return new Parent();
    }

    static void inParent(){
        System.out.println("static method in parent");
    }


    /*GrandParent abc(){
        System.out.println("In grand parent");
        return new GrandParent();
    }*/
}
