package com.old.code;

import java.util.Scanner;

/**
 * Created by Shikhar on 10-06-2018.
 */
public class Point2D {

    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int dist2D(Point2D p){
        int x2 = p.getX();
        int y2 = p.getY();

        final int sum = (int)(Math.pow((x2 - this.x), 2) + Math.pow((y2 - this.y), 2));
        int sqrt = (int)Math.ceil((Math.sqrt(sum)));
        return sqrt;
    }

    void printDistance(double d){
        System.out.println("2D distance = "+(int)d);
    }
}

class Point3D extends Point2D{
    int z;


    public Point3D(int x, int y,int z) {
        super(x, y);
        this.z=z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    int dist3D(Point3D p){
        int x2 = p.getX();
        int y2 = p.getY();
        int z2 = p.getZ();

        final int sum = (int)(Math.pow((x2 - this.x), 2) + Math.pow((y2 - this.y), 2) + Math.pow((z2-this.z),2));
        int sqrt = (int)Math.ceil((Math.sqrt(sum)));
        return sqrt;
    }

    void printDistance(double d){
        System.out.println("3D distance = "+(int)d);
    }

}

class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();
        scanner.close();

        Point3D p1 = new Point3D(x1, y1, z1);
        Point3D p2 = new Point3D(x2, y2, z2);
        double d2 = p1.dist2D(p2);
        double d3 = p1.dist3D(p2);
        // The code below uses runtime polymorphism to call the overridden printDistance method:
        Point2D p = new Point2D(0, 0);
        p.printDistance(d2);
        p = p1;
        p.printDistance(d3);
    }
}
