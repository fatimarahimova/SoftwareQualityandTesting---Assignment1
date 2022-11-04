/* @Author
 * Student Name: <student_name>
 * Student ID: <student_id>
 */

package com.blg475e_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ISBNTest {

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        long num1 = 12345678L;
        long num2 = 1234567890123L;

        boolean result1 = ISBN.checkISBN(num1);
        boolean result2 = ISBN.checkISBN(num2);

        assertFalse(result1, num1 + " is a valid ISBN.");
        assertFalse(result2, num2 + " is a valid ISBN.");

    }

    @Test
    public void test3() {
        long num = 1234567890123L;

        boolean result = ISBN.checkISBN(num);

        assertFalse(result, num + " is a valid ISBN.");
    }

    @Test
    public void test4() {
        long num1 = 1020304050609L;

        boolean result1 = ISBN.checkISBN(num1);

        assertFalse(result1, num1 + " is a valid ISBN.");
    }
}