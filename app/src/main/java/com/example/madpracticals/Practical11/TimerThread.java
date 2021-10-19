package com.example.madpracticals.Practical11;

public class TimerThread extends Thread {

        public int count = 0;

        @Override
        public void run() {
            try {
                Thread.sleep(1500);
                updateCount();
                Thread.sleep(1500);
                updateCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public void updateCount() {
            count++;
        }

        public Integer getCount() {
            return this.count;
        }
}
