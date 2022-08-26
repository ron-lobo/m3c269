package org.ron.m3.enums;

public class EnumUser {

    public static void main(String[] args) {
        EnumUser enumUser = new EnumUser();
        enumUser.sayHi();

        for (Season season : Season.values()) {
            enumUser.seasons(season);
        }

        String[] strings = new String[]{"Spring", "summer", "AutUmN", "winTER", "", "monday", null, "fall"};
        for (String str : strings) {
            Season s0 = Season.getSeason(str);
            if (s0 == null) {
                System.out.println("season not found '" + str + "'");
            } else {
                System.out.println("season = " + s0 + " : " + s0.getLastStart());
            }
        }
    }

    private void seasons(Season season) {
        System.out.printf("name = %s, ordinal = %d%n", season.name(), season.ordinal());
        String x = season.getAltName() == null ? "" : " also known as " + season.getAltName();
        System.out.println("Last " + season.getName(false) + x + " began on " + season.getLastStart());
        System.out.println();
    }

    private void sayHi() {
        sayHi("Harry", Gender.MALE);
        sayHi("Hermione", Gender.FEMALE);
        sayHi("Nobby", Gender.UNKNOWN);
    }

    public void sayHi(String name, Gender gender) {
        switch (gender) {
            case MALE -> System.out.println("Hi Mr " + name);
            case FEMALE -> System.out.println("Hi Ms " + name);
            default -> System.out.println("Hi " + name);
        }

        String salutation = switch (gender) {
            case MALE -> "Mr";
            case FEMALE -> "Ms";
            default -> "";
        };
        System.out.printf("Hi %s %s%n", salutation, name);
    }

    private void ternaryExample(int x, int y, int z) {
        String s0 = (x == 0 && y == 0) || z == 0 ? "A" : "B";
        String s1 = x < 0 ? x > 0 ? "A" : "B" : "C";
    }
}
