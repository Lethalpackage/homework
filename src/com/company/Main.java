package com.company;

public class Main {

        private static final int one = 1;
        private static final int five = 5;
        private static final int seven = 7;


        public static void main(String[] args) {


                Timer timer = new Timer();


            Thread timerThread = new Thread(timer);
            Thread thread1 = new Thread(new SecondTimer(timer, one));
            Thread thread2 = new Thread(new SecondTimer(timer, five));
            Thread thread3 = new Thread(new SecondTimer(timer, seven));

            timerThread.start();
            thread1.start();
            thread2.start();
            System.out.println("Main thread");
            thread3.start();

            timerThread.interrupt();
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
        }
    }

