package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    private final Map<Value , String> valueStringMap;

    public MapTest(Map<Value, String> valueStringMap) {
        this.valueStringMap = valueStringMap;
    }

    static class Value{
        String value;

        public Value(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Value value1 = (Value) o;

            return value.equals(value1.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }


    private void addValue(String value){
        valueStringMap.putIfAbsent(new Value(value) , value);
    }

    private void connectValues(String s1 , String s2){
        Value v1 = new Value(s1);
        Value v2 = new Value(s2);

        valueStringMap.get(v1).concat(s1);
    }


    public static void main(String[] args) {
        MapTest mapTest = new MapTest(new HashMap<>());
        mapTest.addValue("1");
        mapTest.addValue("2");
        mapTest.connectValues("1","2");

    }

}
