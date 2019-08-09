package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void setFly(int fly);
    }

    public interface CanRun {
        public String getBird();
    }

    public interface CanSwim {
        public int getSwim();
    }
}

