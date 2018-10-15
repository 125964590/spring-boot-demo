package top.jbzm.test.JUnit5;


import org.junit.jupiter.api.*;

/**
 * @author zhengyi
 * @date 2018/10/15 2:06 PM
 **/
public class TestAnnotations {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    @Tag("DEV")
    @Test
    void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
       // Assertions.assertEquals(4,2);
    }

    @Tag("PROD")
    @Disabled
    @Test
    void testCalcTwo() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(6, 2);
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll executed");
    }
}