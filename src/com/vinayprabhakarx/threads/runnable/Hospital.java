package com.vinayprabhakarx.threads.runnable;

public class Hospital implements Runnable {
    final String res1 = "Room";
    final String res2 = "Doctor";

    public void run() {
        String threadName =  Thread.currentThread().getName();
        if (threadName.equals("Tom"))
            tomTreatment();
        else
            jerryTreatment();
    }

    public void tomTreatment() {
        try {
            synchronized (res1) {
                System.out.println("Tom Accessing the " + res1);
                Thread.sleep(5000);
                synchronized (res2) {
                    System.out.println("Tom Taking Treatment By " + res2);
                    Thread.sleep(5000);
                    System.out.println(res2 + " Treated Tom!");
                }
                System.out.println("Tom Leaving the " + res1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jerryTreatment() {
        try {
            synchronized (res1) {
                System.out.println("Jerry Accessing the " + res1);
                Thread.sleep(5000);
                synchronized (res2) {
                    System.out.println("Jerry Taking Treatment By " + res2);
                    Thread.sleep(5000);
                    System.out.println(res2 + " Treated Jerry!");
                }
                System.out.println("Jerry Leaving the " + res1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Execute {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Thread thread1 = new Thread(hospital);
        Thread thread2 = new Thread(hospital);

        thread1.setName("Tom");
        thread2.setName("Jerry");

        thread1.start();
        thread2.start();
    }
}