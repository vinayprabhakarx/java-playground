package com.vinayprabhakarx.oops.classes;

public class LocalClass {
    int a = 10;

    static int c = 30;

    void outerDisp() {
        class InnerProgram {
            static  int d = 40;
            int b = 20;

            void innerDisp(){
                System.out.println("inside the inner class Disp");
                System.out.println(b);
                System.out.println(a);
                System.out.println(c);
                System.out.println(d);
            }
        }
        System.out.println("Inside the outer class disp:");
        System.out.println(a);
        InnerProgram innerProgram = new InnerProgram();
        innerProgram.innerDisp();
        System.out.println(c);
        System.out.println(innerProgram.d);
    }
}

