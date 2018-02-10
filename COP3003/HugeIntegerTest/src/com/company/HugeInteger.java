package com.company;

import java.util.Arrays;

public class HugeInteger {

    private static final int NUM_DIGITS = 40;
    private int digits[] = new int[NUM_DIGITS];
    private boolean positive = true;
    private int size = 0;


    @Override
    public String toString() {
        String number = "";
        int j = 0;
        int position = 0;

        if (this.positive) {
            number += "";
        } else {
            number += "-";
        }
        while (this.digits[j] == 0) {
            position = j;
            j++;
        }

        for (int i = position + 1; i < NUM_DIGITS; i++) {
            number += this.digits[i];
        }

        return number;
    }
    // Constructor

    public HugeInteger(String num) {
        int length = num.length();
        int j = length - 1;
        for (int i = NUM_DIGITS - 1; i > NUM_DIGITS - 1 - length; i--) {
            size++;
            if (num.charAt(0) == 45) {
                this.digits[i] = num.charAt(j - 1) - '0';
                this.positive = false;
                length--;
            } else if (num.charAt(0) != 45) {
                this.digits[i] = num.charAt(j) - '0';

            }
            j--;

        }

    }

    // FOR COMPARISON

    public boolean isEqualTo(HugeInteger hi) {
        if (Arrays.equals(this.digits, hi.digits)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNotEqualTo(HugeInteger hi) {
        if (Arrays.equals(this.digits, hi.digits)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isGreaterThan(HugeInteger hi) {
        if (this.isEqualTo(hi))
            return false; // maybe else statement later
        if (!this.positive && !hi.positive) {
            for (int i = 39; i >= 0; i--) {
                if (i < 40) {
                    for (int k = 0; k <= i; k++) {
                        if (this.digits[k] < hi.digits[k])
                            return true;
                        else if (this.digits[k] > hi.digits[k])
                            return false;
                    }
                }
            }
        }
        if (this.positive && !hi.positive)
            return true;

        if (!this.positive && hi.positive)
            return false;

        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            if (i < NUM_DIGITS) {
                for (int k = 0; k <= i; k++) {
                    if (this.digits[k] > hi.digits[k])
                        return true;
                    else if (this.digits[k] < hi.digits[k])
                        return false;
                }
                return true;
            } else
                return false;
        }
        return true;

    }


    public boolean isLessThan(HugeInteger hi) {

        if (isGreaterThan(hi)) {
            return false;
        } else if (isEqualTo(hi)) {
            return false;
        }
        return true;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hi) {
        return !isLessThan(hi);
    }

    public boolean isLessThanOrEqualTo(HugeInteger hi) {
        return !isGreaterThan(hi);
    }

    public void negate() {
        this.positive = !this.positive;

    }

    public void add(HugeInteger hi) {
        if (this.positive != hi.positive) {
            if (this.positive) {
                hi.negate();

                if (this.isGreaterThan(hi)) {
                    this.digits = subtractArrayDigits(this.digits, hi.digits);
                } else {
                    this.digits = subtractArrayDigits(hi.digits, this.digits);
                    negate();
                }
                hi.negate();
            } else {


            }
        } else {
            this.digits = addArrayDigits(this.digits, hi.digits);
        }
    }


    private static int[] addArrayDigits(int[] array1, int[] array2) {
        int[] array3 = new int[NUM_DIGITS];
        int carry = 0;

        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            array3[i] = array1[i] + array2[i] + carry;

            if (array3[i] >= 10) {
                carry = 1;
                array3[i] -= 10;
            } else {
                carry = 0;
            }
        }

        return array3;
    }

    private static int[] subtractArrayDigits(int[] array1, int[] array2) {
        int[] array3 = new int[NUM_DIGITS];
        int carry = 0;

        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            array3[i] = array1[i] - array2[i] + carry;

            if (array1[i] >= array2[i]) {
                carry = 0;
            } else {
                carry = -1;
                array3[i] += 10;
            }
        }
        return array3;

    }

}






