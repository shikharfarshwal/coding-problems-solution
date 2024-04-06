package com.old.code;

/**
 * Created by Shikhar on 02-04-2018.
 */
class Alpha
{
    static String s = " ";
    protected void Alpha()
    {
        s += "alpha ";
    }
}
class SubAlpha extends Alpha
{
    public void Alpha()
    {
        s += "sub ";
    }

}

class SubSubAlpha extends SubAlpha
{
    private SubSubAlpha()
    {
        s += "subsub ";
    }
    public static void main(String[] args)
    {
        new SubSubAlpha();
        System.out.println(s);
    }
}

