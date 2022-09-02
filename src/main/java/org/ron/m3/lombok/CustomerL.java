package org.ron.m3.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

//@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class CustomerL {
    private final String name;
    private String contact;
    private String contact2;
    private String email;
    @Setter
    private List<String> address;
    @Setter
    private LocalDate startDate;
    @Setter
    private int discountLevel;
    @Setter
    private int salesLevel;

    public int doSomething() {
        return 0;
    }
}
