package com.vinayprabhakarx.classes;

/*Main class demonstrating the usage of Student class
 This program creates Student objects and demonstrates accessing their
 properties and methods
 */
public class Main {
    public static void main(String[] args) {

        // Creating the first Student object
        Student s1 = new Student();

        // Setting properties for student 1
        s1.id = 91;
        s1.name = "Vinay Prabhakar";
        s1.age = 22;

        // Displaying student 1 details
        System.out.println(s1.id);
        System.out.println(s1.name);
        System.out.println(s1.age);

        // Calling methods for student 1
        s1.study();
        s1.interviewPre();

        // Creating the second Student object
        Student s2 = new Student();

        // Setting and displaying properties for student 2 (combined assignment and
        // print)
        System.out.println(s2.id = 96);
        System.out.println(s2.name = "Santosh Kumar");
        System.out.println(s2.age = 21);

        // Calling methods for student 2
        s2.study();
        s2.interviewPre();

    }

}
