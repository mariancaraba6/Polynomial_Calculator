package com.example.pt2024_30229_caraba_marian_assignment_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Polynomial {

    private Map<Integer, Monomial> polynomial;

    public Polynomial(Polynomial polynomialToBeCopied) {
        this.polynomial = polynomialToBeCopied.getPolynomial();
    }

    public Polynomial() {
        polynomial = new HashMap<>();
    }

    public Map<Integer, Monomial> getPolynomial() {
        return polynomial;
    }

    public void addMonomial(Monomial monomial) {
        polynomial.put(monomial.getDegree(), monomial);
    }

    public boolean isZero() {
        if (polynomial.isEmpty()) {
            throw new IllegalStateException("Polynomial is empty");
        }
        for(Map.Entry<Integer, Monomial> entry : polynomial.entrySet()) {
            if(entry.getValue().getCoefficient() != 0.0) {
                return false;
            }
        }
        return true;
    }

    public Integer highestDegree () {
        int highest = -1;
        for (Map.Entry<Integer, Monomial> entry : polynomial.entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue().getCoefficient();
            if(degree>highest && coefficient != 0) {
                highest = degree;
            }
        }
        return highest;
    }

    public Monomial getLeadingTerm() {
        if (polynomial.isEmpty()) {
            throw new IllegalStateException("Polynomial is empty");
        }

        int highestDegree = Integer.MIN_VALUE;
        Monomial leadingTerm = null;

        for (Map.Entry<Integer, Monomial> entry : polynomial.entrySet()) {
            int degree = entry.getKey();
            if (degree > highestDegree && entry.getValue().getCoefficient()!=0) {
                highestDegree = degree;
                leadingTerm = entry.getValue();
            }
        }

        return leadingTerm;
    }

    public Polynomial multiply(Monomial toBeMultiplied) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry: polynomial.entrySet()) {
            Monomial currentTerm = entry.getValue();
            Integer degree = toBeMultiplied.getDegree() + currentTerm.getDegree();
            double coefficient = toBeMultiplied.getCoefficient() * currentTerm.getCoefficient();
            result.addMonomial(new Monomial(degree, coefficient));
        }

        return result;
    }

    public String toString() {
        if (polynomial.isEmpty()) {
            return "0";
        }

        StringBuilder polynomialString = new StringBuilder();

        for (Map.Entry<Integer, Monomial> entry : polynomial.entrySet()) {
            Monomial monomial = entry.getValue();
            int degree = entry.getKey();
            double coefficient = monomial.getCoefficient();

            // Append the coefficient and degree
            if (coefficient != 0) {
                if (!polynomialString.isEmpty()) {
                    if (coefficient > 0) {
                        polynomialString.append(" + ");
                    } else {
                        polynomialString.append(" - ");
                        coefficient = Math.abs(coefficient);
                    }
                }
                if (coefficient != 1 || degree == 0) {
                    polynomialString.append(coefficient);
                }
                if (degree > 0) {
                    polynomialString.append("x");
                    if (degree > 1) {
                        polynomialString.append("^").append(degree);
                    }
                }
            }
        }
        return polynomialString.toString();
    }

}
