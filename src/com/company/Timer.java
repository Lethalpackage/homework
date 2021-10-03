package com.company;

public class Timer  implements  Runnable{
    public int time = 1;

    @Override
    public void run() {
        for (int i = 0; i < 35; i++) {
            try {
                Thread.sleep(1000);
                synchronized (this) {
                    time++;
                    this.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("Îøèáêà");
            }
        }
    }
}

