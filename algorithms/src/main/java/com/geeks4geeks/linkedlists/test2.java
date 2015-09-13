package com.geeks4geeks.linkedlists;


import java.io.FileNotFoundException;
import java.io.IOException;

class Tree implements Runnable {

    int index = 5;
    public void printVal()
    {  System.out.println( "Super" );
    }

    int methodOne( int a, long b ) throws IOException
    { // code that performs some calculations
        return 0;
    }
    float methodTwo( char a, int b )
    { // code that performs other calculations
        return 0f;
    }

    @Override
    public void run() {
        //
    }
}
class Pine extends Tree{

//    int methodOne( int c, long d ) throws
//            ArithmeticException{
//        return 0;
//    }

    //long methodOne( int c, long d ){ return 0;}

//    int methodOne( int c, long d ) throws
//            FileNotFoundException { return 0;}
}
class Oak extends Tree{
    int index = 2;
    public void printVal()
    {  System.out.println( "Sub" );
    }
}

class red extends Thread{

}
public class test2
{  public static void main( String[] args )
{  Tree tree = new Pine();

    Pine pine = new Pine();

    if( tree instanceof Pine )
        System.out.println( "Pine" );

    if( tree instanceof Tree )
        System.out.println( "Tree" );

    if( tree instanceof Oak )
        System.out.println( "Oak" );

    else System.out.println( "Oops" );


    Tree tree1 = new Tree();
    Pine pine1 = new Pine();

    Tree oak = new Oak();
    //tree1 = pine1;

    System.out.print( oak.index + "," );
    oak.printVal();
}
}

