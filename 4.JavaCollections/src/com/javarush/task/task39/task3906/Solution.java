package com.javarush.task.task39.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem();
        LightBulb lightBulb = new LightBulb();

        ElectricPowerSwitch electricPowerSwitch1 = new ElectricPowerSwitch(securitySystem);
        electricPowerSwitch1.press();
        electricPowerSwitch1.press();

        ElectricPowerSwitch electricPowerSwitch2 = new ElectricPowerSwitch(lightBulb);
        electricPowerSwitch2.press();
        electricPowerSwitch2.press();
    }
}
