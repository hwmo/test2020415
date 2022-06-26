package test;

import com.hwmo.test.junit.Calculate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    private Calculate calculate;
    private String s;


    @BeforeEach
    void setUp() {

        calculate = new Calculate();

    }

    @AfterEach
    void tearDown() {

        System.out.println("end");

    }

    @Test
    void add() {

        assertEquals(2, calculate.add(1, 1));

    }

    @Test
    void subtract() {
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }
}