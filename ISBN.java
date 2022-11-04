/* @Author
 * Doğukan Arslan
 *
 * PLEASE DO NOT CHANGE THIS FILE!
 *
 */
package com.blg475e_1;

// ISBN class to check whether the given number is a valid ISBN or not
public class ISBN {

    static boolean checkISBN(long number) {
        int sum = 0;
        int i, t, intNumber;
        String strNumber;

        strNumber = "" + number;

        if (strNumber.length() != 13) {
            return false;
        }

        for (i = strNumber.length(); i > 0; i--) {
            intNumber = Integer.parseInt(strNumber.substring(i-1, i));

            if (i % 2 == 0) {
                sum = sum + intNumber;
            } else {
                sum = sum + intNumber * 3;
            }

        }

        // check whether the sum is divisible by 10 or not
        if ((sum % 10) == 0) {
            return true;
        }

        return false;

    }

}