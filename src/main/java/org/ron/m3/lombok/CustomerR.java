package org.ron.m3.lombok;

import java.time.LocalDate;
import java.util.List;

public record CustomerR(
        String name,
        String contact,
        String email,
        List<String> address,
        LocalDate startDate,
        int discountLevel,
        int salesLevel
) {
}
