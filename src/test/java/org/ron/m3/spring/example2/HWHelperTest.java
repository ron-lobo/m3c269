package org.ron.m3.spring.example2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class HWHelperTest {

    @Mock
    private DepA depA;

    @Mock
    private HWDB hwDB;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAssembleMessage() {
        Mockito.when(depA.getMsgStart()).thenReturn("ABC").thenReturn("DEF");
        Mockito.when(depA.getMsgEnd()).thenReturn("XYZ");
        Mockito.when(hwDB.getCentre()).thenReturn("ijk");

        HWHelperImpl hwHelper = new HWHelperImpl(depA, hwDB);
        String s = hwHelper.assembleMessage();
        System.out.println(s);
        Assertions.assertEquals(s, "ABC ijk XYZ");

        s = hwHelper.assembleMessage();
        System.out.println(s);
        Assertions.assertEquals(s, "DEF ijk XYZ");

        Mockito.verify(hwDB, Mockito.times(2)).getCentre();
        Mockito.verify(depA, Mockito.times(2)).getMsgEnd();
    }
}