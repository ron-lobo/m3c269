package org.ron.m3.enums;

import java.time.LocalDate;
import java.time.Month;

public enum Season {

    SPRING(Month.MARCH),
    SUMMER(Month.JUNE),
    AUTUMN(Month.SEPTEMBER, "Fall"),
    WINTER(Month.DECEMBER);

    private final String altName;
    private final Month startMonth;

    Season(Month startMonth) {
        this(startMonth, null);
    }

    Season(Month startMonth, String altName) {
        this.startMonth = startMonth;
        this.altName = altName;
    }

    public Month getStartMonth() {
        return startMonth;
    }

    public String getAltName() {
        return altName;
    }

    public LocalDate getLastStart() {
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), startMonth, 23);
        if (start.isAfter(LocalDate.now())) {
            start = start.minusYears(1);
        }
        return start;
    }

    public String getName(boolean isAllLower) {
        return isAllLower ? name().toLowerCase() : name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static Season getSeason_v1(String str) {
        try {
            return valueOf(str.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public static Season getSeason(String str) {
        for (Season s : values()) {
            if (s.name().equalsIgnoreCase(str) ||
                    (s.getAltName() != null && s.getAltName().equalsIgnoreCase(str))) {
                return s;
            }
        }
        return null;
    }
}
