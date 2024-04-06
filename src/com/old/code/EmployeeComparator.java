package com.old.code;

import java.util.Comparator;

/**
 * Created by Shikhar on 03-01-2018.
 */
public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());

    }
}
