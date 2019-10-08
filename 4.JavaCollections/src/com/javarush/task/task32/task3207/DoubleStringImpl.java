package com.javarush.task.task32.task3207;

import java.rmi.RemoteException;

public class DoubleStringImpl implements StringWork {
    @Override
    public String doubleString(String str) throws RemoteException {
        return str + str;
    }

    @Override
    public String upperString(String str) throws RemoteException {
        return str.toUpperCase();
    }
}