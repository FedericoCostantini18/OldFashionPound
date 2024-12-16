package com.example.OldFashionPound;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OldFashionPoundTest {

    @Test
    void testConstructorFromTotalPence() {
        OldFashionPound price = new OldFashionPound(254);
        assertEquals(1, price.getSterline());
        assertEquals(1, price.getScellini());
        assertEquals(2, price.getPence());
    }

    @Test
    void testConstructorFromComponents() {
        OldFashionPound price = new OldFashionPound(2, 15, 8);
        assertEquals(2, price.getSterline());
        assertEquals(15, price.getScellini());
        assertEquals(8, price.getPence());

        OldFashionPound normalizedPrice = new OldFashionPound(1, 25, 14);
        assertEquals(2, normalizedPrice.getSterline());
        assertEquals(6, normalizedPrice.getScellini());
        assertEquals(2, normalizedPrice.getPence());
    }

    @Test
    void testAdd() {
        OldFashionPound price1 = new OldFashionPound(2, 15, 8);
        OldFashionPound price2 = new OldFashionPound(1, 4, 4);
        OldFashionPound result = price1.add(price2);

        assertEquals(4, result.getSterline());
        assertEquals(0, result.getScellini());
        assertEquals(0, result.getPence());
    }

    @Test
    void testSubtractValid() {
        OldFashionPound price1 = new OldFashionPound(3, 10, 8);
        OldFashionPound price2 = new OldFashionPound(1, 4, 4);
        OldFashionPound result = price1.subtract(price2);

        assertEquals(2, result.getSterline());
        assertEquals(6, result.getScellini());
        assertEquals(4, result.getPence());
    }

    @Test
    void testMultiplyValid() {
        OldFashionPound price = new OldFashionPound(1, 4, 4);
        OldFashionPound result = price.multiply(2);

        assertEquals(2, result.getSterline());
        assertEquals(8, result.getScellini());
        assertEquals(8, result.getPence());
    }

    @Test
    void testMultiplyInvalid() {
        OldFashionPound price = new OldFashionPound(1, 4, 4);

        assertThrows(IllegalArgumentException.class, () -> price.multiply(0));
    }

    @Test
    void testDivideValid() {
        OldFashionPound price = new OldFashionPound(3, 10, 8);
        String result = price.divide(2);

        assertEquals("1p 15s 4d()", result);
    }

    @Test
    void testDivideWithRemainder() {
        OldFashionPound price = new OldFashionPound(3, 10, 8);
        String result = price.divide(3);

        assertEquals("1p 3s 6d(2d)", result);
    }

    @Test
    void testDivideInvalid() {
        OldFashionPound price = new OldFashionPound(1, 4, 4);

        assertThrows(IllegalArgumentException.class, () -> price.divide(0));
    }

    @Test
    void testToString() {
        OldFashionPound price = new OldFashionPound(2, 15, 8);
        assertEquals("2p 15s 8d", price.toString());

        OldFashionPound price2 = new OldFashionPound(0, 5, 4);
        assertEquals("5s 4d", price2.toString());

        OldFashionPound price3 = new OldFashionPound(0, 0, 9);
        assertEquals("9d", price3.toString());
    }
}
