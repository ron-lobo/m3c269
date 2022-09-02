package org.ron.m3.lombok;

import java.time.LocalDate;

public class Misc {

    public static void main(String[] args) {
        CustomerR customerR = new CustomerR("Hogwartz", "HP", "hp@hogwartz", null, LocalDate.now(), 10, 10);
        System.out.println(customerR);
        int x = customerR.discountLevel();

        CustomerL customerL = new CustomerL("Hogwartz", "HP", "hp@hogwartz", null, LocalDate.now(), 10, 10);

    }
}
