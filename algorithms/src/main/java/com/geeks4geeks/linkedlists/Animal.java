package com.geeks4geeks.linkedlists;

/**
 * Created by ksharma on 8/8/15
 */
public class Animal {
    private int i = 12;

    public Boolean equals(Animal animal) {
        return (this.i == animal.i);

    }
}

class test1 {
    public static void main(String[] args) throws Exception {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        a1.hashCode();
    }
}
