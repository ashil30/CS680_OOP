package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @org.junit.jupiter.api.Test
    void getPrimes() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes,
                gen.getPrimes().toArray() );
    }
    @org.junit.jupiter.api.Test
    void generatePrimes5To5() {
        try {
            PrimeGenerator pGenerator = new PrimeGenerator(5L, 5L);
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("Invalid range test fail");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=5 to=5", ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void generatePrimesNegative() {
        try {
            PrimeGenerator pGenerator = new PrimeGenerator(-5L, 5L);
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("Invalid range test fail");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-5 to=5", ex.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void generatePrimesReverse() {
        try {
            PrimeGenerator pGenerator = new PrimeGenerator(15L, 1L);
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("Invalid range test fail");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=15 to=1", ex.getMessage());
        }

    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}