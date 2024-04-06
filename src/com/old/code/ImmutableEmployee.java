package com.old.code;

/**
 * Created by Shikhar on 17-11-2018.
 */
    final class ImmutableEmployee {

    private int id;

    public ImmutableEmployee(int id) {
        this.id = id;
    }
}

class testEmployeeImmutabiity {

    public static void main(String[] args) {

        ImmutableEmployee immutableEmployee = new ImmutableEmployee(1);

    }
}
