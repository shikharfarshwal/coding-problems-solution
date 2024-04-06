package com.old.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shikhar on 03-01-2018.
 */
public class User implements Comparable<User>{

    int id;
    String name;
    String department;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(User User) {
        if(id==User.id){
            return 0;
        }
        else if(id>User.id)
            return 1;
        else
            return -1;
    }
}
class Test{
    public static void main(String[] args) {
        List<User> UserList=new ArrayList<>();
        UserList.add(new User(30,"Test1"));
        UserList.add(new User(25,"Test2"));
        UserList.add(new User(54,"Test3"));

        Collections.sort(UserList);
        UserList.stream().forEach(e -> System.out.println(e.getId() + " " + e.getName()));
    }
}
