package com.geeks4geeks.arrays;

/**
 * Created by ksharma on 9/3/15.
 */
public class Clock {


    public static void main(String[] args){

        double angle = calcAngle(3,15);

        System.out.print(angle);
    }
    public static double calcAngle(double h, double m)
    {
        // validate the input
        if (h <0 || m < 0 || h >12 || m > 60)
            System.out.println("Wrong input");

        if (h == 12) h = 0;
        if (m == 60) m = 0;

        // Calculate the angles moved by hour and minute hands
        // with reference to 12:00
        double hour_angle =  (0.5 * (h*60 + m));
        double minute_angle =  (6*m);

        // Find the difference between two angles
        double angle = Math.abs(hour_angle - minute_angle);

        // Return the smaller angle of two possible angles
        angle = Math.min(360-angle, angle);

        return angle;
    }
}
