package org.ron.m3.spring.example3;

import java.util.Random;

public class RandomisationService {

    private Random random = new Random();

    public int getRandInt(int min, int max) {
        return random.nextInt(min, max);
    }
}
