package ru.cft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;

public class JUnitTestSimple {

    @Test
    void simpleTest() {
        int expected = 23;
        int actual = 23;

        System.out.println("Run simpleTest!!!");
        assertEquals(expected, actual);

        Assertions.assertThat(true);
    }
}
