package com.javarush.task.task06.task0615;

/* 
Феншуй и статики
*/

public class Solution {

    public static int A = 5;
    public int B = 2;
    public int C = A * B;

    public static void main(String[] args) {
        A = 15;

        System.out.println(Solution.A);

        A = 30;

        Solution s1 = new Solution();
        System.out.println(s1.C);

    }
}
