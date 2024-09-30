package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n### beforeAll\n");
    }
    @AfterAll
    static void aftereAll() {
        System.out.println("\n### beforeAll\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach()");
        result = getResult();

    }

    @AfterEach
    void afterEach() {
        System.out.println("### afterEach()\n");
        result = 0;
    }

    @Test
    void firstTest() {
        System.out.println("###     firstTest()");
        Assertions.assertTrue(result>2);
    }

    @Test
    void secondTest() {
        System.out.println("###     secondTest()");
        Assertions.assertTrue(result>2);
    }

    @Test
    void thirtTest() {
        System.out.println("###     thirtTest()");
        Assertions.assertTrue(result>2);
    }

    private int getResult() {
        return 3;
    }

}
