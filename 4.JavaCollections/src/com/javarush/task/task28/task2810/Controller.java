package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

public class Controller {
    private Provider[] providers;

    public Controller(Provider...providers) {
        if (providers == null || providers.length == 0)
            throw new IllegalArgumentException();
        this.providers = Arrays.copyOf(providers, providers.length);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
