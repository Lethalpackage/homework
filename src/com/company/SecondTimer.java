package com.company;

public class SecondTimer implements Runnable {
    private final Timer timer;
    private final int shareTime;

    public SecondTimer(Timer timer, int shareTime) {
        this.timer = timer;
        this.shareTime = shareTime;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (timer) {

                try {
                    timer.wait();
                } catch (InterruptedException e) {
                }

                if (Thread.interrupted()) return;

                if (timer.time % this.shareTime == 0) {
                    System.out.println(" Таймер " + timer.time + ". Сообщение " + this.shareTime);
                }

                if (35 == timer.time) {
                    return;
                }
            }
        }
    }
}

