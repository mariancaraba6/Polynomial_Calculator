package com.example.pt2024_30229_caraba_marian_assignment_1;

import polynomialPackage.Monomial;
import polynomialPackage.Operations;
import polynomialPackage.Polynomial;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {
    @Test
    public void testAdd() {
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.addMonomial(new Monomial(2, 3.0));
        pol1.addMonomial(new Monomial(1, 2.0));
        pol1.addMonomial(new Monomial(0, 1.0));

        pol2.addMonomial(new Monomial(3, 4.0));
        pol2.addMonomial(new Monomial(2, 3.0));
        pol2.addMonomial(new Monomial(0, -1.0));

        Polynomial result = Operations.add(pol1, pol2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomial(new Monomial(3, 4.0));
        expectedResult.addMonomial(new Monomial(2, 6.0));
        expectedResult.addMonomial(new Monomial(1, 2.0));
        expectedResult.addMonomial(new Monomial(0, 0.0));

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testSubtract() {
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.addMonomial(new Monomial(2, 3.0));
        pol1.addMonomial(new Monomial(1, 2.0));
        pol1.addMonomial(new Monomial(0, 1.0));

        pol2.addMonomial(new Monomial(3, 4.0));
        pol2.addMonomial(new Monomial(2, 3.0));
        pol2.addMonomial(new Monomial(0, -1.0));

        Polynomial result = Operations.subtract(pol1, pol2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomial(new Monomial(3, -4.0));
        expectedResult.addMonomial(new Monomial(2, 0.0));
        expectedResult.addMonomial(new Monomial(1, 2.0));
        expectedResult.addMonomial(new Monomial(0, 2.0));

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testMultiply() {
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.addMonomial(new Monomial(2, 3.0));
        pol1.addMonomial(new Monomial(1, 2.0));
        pol1.addMonomial(new Monomial(0, 1.0));

        pol2.addMonomial(new Monomial(3, 4.0));
        pol2.addMonomial(new Monomial(2, 3.0));
        pol2.addMonomial(new Monomial(0, -1.0));

        Polynomial result = Operations.multiply(pol1, pol2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomial(new Monomial(5, 12.0));
        expectedResult.addMonomial(new Monomial(4, 17.0));
        expectedResult.addMonomial(new Monomial(3, 10.0));
        expectedResult.addMonomial(new Monomial(1, -2.0));
        expectedResult.addMonomial(new Monomial(0, -1.0));

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testDivision() {
        // Create dividend polynomial: 3.0x^2 + 2.0x + 1.0
        Polynomial dividend = new Polynomial();
        dividend.addMonomial(new Monomial(2, 3.0));
        dividend.addMonomial(new Monomial(1, 2.0));
        dividend.addMonomial(new Monomial(0, 1.0));

        // Create divisor polynomial: 1.0x + 1.0
        Polynomial divisor = new Polynomial();
        divisor.addMonomial(new Monomial(1, 1.0));
        divisor.addMonomial(new Monomial(0, 1.0));

        // Expected quotient polynomial: 2.0x + 1.0
        Polynomial expectedQuotient = new Polynomial();
        expectedQuotient.addMonomial(new Monomial(1, 3.0));
        expectedQuotient.addMonomial(new Monomial(0, -1.0));

        // Expected remainder polynomial: 0 (since dividend evenly divisible by divisor)
        Polynomial expectedRemainder = new Polynomial();
        expectedRemainder.addMonomial(new Monomial(0, 2.0));

        // Call the divide method
        ArrayList<Polynomial> result = Operations.divide(dividend, divisor);

        // Check if the quotient and remainder match the expected values
        assertEquals(expectedQuotient.toString(), result.get(0).toString());
        assertEquals(expectedRemainder.toString(), result.get(1).toString());

    }

    @Test
    public void testDerivation() {
        Polynomial pol1 = new Polynomial();

        pol1.addMonomial(new Monomial(2, 3.0));
        pol1.addMonomial(new Monomial(1, 2.0));
        pol1.addMonomial(new Monomial(0, 1.0));

        Polynomial result = Operations.derive(pol1);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomial(new Monomial(1, 6.0));
        expectedResult.addMonomial(new Monomial(0, 2.0));

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testIntegration() {
        Polynomial pol = new Polynomial();

        pol.addMonomial(new Monomial(2, 3.0));
        pol.addMonomial(new Monomial(1, 2.0));
        pol.addMonomial(new Monomial(0, 1.0));

        Polynomial result = Operations.integrate(pol);

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomial(new Monomial(3, 1.0));
        expectedResult.addMonomial(new Monomial(2, 1.0));
        expectedResult.addMonomial(new Monomial(1, 1.0));

        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    public void testRegEx() {
        String string1 = "-5x^3-3x^2+6x-4";
        String string2 = "4x^2+4x-10";

        Polynomial polynomial1 = Operations.stringToPolynomial(string1);
        Polynomial polynomial2 = Operations.stringToPolynomial(string2);

        System.out.println(polynomial1);
        System.out.println(polynomial2);

    }
}