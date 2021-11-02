package com.github.denakh.deckofcardsapi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Random;

public class TestUtilities {

    private static final NumberFormat NUMBER_FORMATTER = new DecimalFormat("00000");
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public static String generateUniqueName(String prefix, int maxLength) {
        final String randomNumber = generateNumber();
        String betterName = prefix + new Date().getTime() + "-" + randomNumber;
        if (betterName.length() > maxLength) {
            betterName = betterName.substring(0, maxLength);
        }
        return (betterName.toUpperCase());
    }

    public static String generateNumber() {
        return NUMBER_FORMATTER.format(RANDOM_NUMBER_GENERATOR.nextInt(1000000));
    }

    public static Integer generateInteger(int lowerRange, int upperRange) {
        return RANDOM_NUMBER_GENERATOR.nextInt(upperRange - lowerRange) + lowerRange;
    }
}
