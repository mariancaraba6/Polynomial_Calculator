package polynomialPackage;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

    public static Polynomial add(Polynomial pol1, Polynomial pol2) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry : pol1.getPolynomial().entrySet()) {
            Integer degree = entry.getKey();
            double coefficient = entry.getValue().getCoefficient();
            result.addMonomial(new Monomial(degree, coefficient));
        }

        for(Map.Entry<Integer, Monomial> entry : pol2.getPolynomial().entrySet()) {
            Integer degree = entry.getKey();
            double coefficient = entry.getValue().getCoefficient();
            if(result.getPolynomial().containsKey(degree)) {
                coefficient += result.getPolynomial().get(degree).getCoefficient();
                result.getPolynomial().get(degree).setCoefficient(coefficient);
            } else {
                result.addMonomial(new Monomial(degree, coefficient));
            }
        }

        return result;
    }

    public static Polynomial subtract(Polynomial pol1, Polynomial pol2) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry : pol1.getPolynomial().entrySet()) {
            Integer degree = entry.getKey();
            double coefficient = entry.getValue().getCoefficient();
            result.addMonomial(new Monomial(degree, coefficient));
        }

        for(Map.Entry<Integer, Monomial> entry : pol2.getPolynomial().entrySet()) {
            Integer degree = entry.getKey();
            double coefficient = -entry.getValue().getCoefficient();
            if(result.getPolynomial().containsKey(degree)) {
                coefficient += result.getPolynomial().get(degree).getCoefficient();
                result.getPolynomial().get(degree).setCoefficient(coefficient);
            } else {
                result.addMonomial(new Monomial(degree, coefficient));
            }
        }

        return result;
    }

    public static Polynomial multiply (Polynomial pol1, Polynomial pol2) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry1 : pol1.getPolynomial().entrySet()) {
            for(Map.Entry<Integer, Monomial> entry2 : pol2.getPolynomial().entrySet()) {
                int degree = entry1.getKey() + entry2.getKey();
                double coefficient = entry1.getValue().getCoefficient() * entry2.getValue().getCoefficient();
                if(result.getPolynomial().containsKey(degree)) {
                    coefficient += result.getPolynomial().get(degree).getCoefficient();
                    result.getPolynomial().get(degree).setCoefficient(coefficient);
                } else {
                    result.addMonomial(new Monomial(degree, coefficient));
                }
            }
        }

        return result;
    }

    public static ArrayList<Polynomial> divide(Polynomial dividend, Polynomial divisor) {
        if(divisor.isZero()) {
            throw new ArithmeticException("You cannot divide by zero!\n");
        }

        ArrayList<Polynomial> result = new ArrayList<>();
        Polynomial quotient =  new Polynomial();
        Polynomial reminder =  new Polynomial(dividend);

        while(!reminder.isZero() && reminder.highestDegree() >= divisor.highestDegree()) {
            Monomial leadingDividendTerm = reminder.getLeadingTerm();
            Monomial leadingDivisorTerm = divisor.getLeadingTerm();

            Monomial toBeAdded = leadingDividendTerm.divideMonomial(leadingDivisorTerm);
            quotient.addMonomial(toBeAdded);

            Polynomial toBeSubtracted = divisor.multiply(toBeAdded);
            reminder = subtract(reminder, toBeSubtracted);
        }

        result.add(quotient);
        result.add(reminder);

        return result;
    }

    public static Polynomial derive (Polynomial pol) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry : pol.getPolynomial().entrySet()) {
            int degree = entry.getKey();
            double coefficient = entry.getValue().getCoefficient();

            if(degree != 0) {
                coefficient *= degree;
                degree--;
                result.addMonomial(new Monomial(degree, coefficient));
            }
        }

        return result;
    }

    public static Polynomial integrate(Polynomial pol) {
        Polynomial result = new Polynomial();

        for(Map.Entry<Integer, Monomial> entry : pol.getPolynomial().entrySet()) {
            int degree = entry.getKey() + 1;
            double coefficient = entry.getValue().getCoefficient() / degree;

            result.addMonomial(new Monomial(degree, coefficient));
        }

        return result;
    }
    public static Polynomial stringToPolynomial(String string) {
        Polynomial newPolynomial = new Polynomial();
//        Pattern pattern = Pattern.compile("(\\+|-)?(\\d+x|\\d+)(\\^\\d+)?");
        Pattern pattern = Pattern.compile("(\\+|-)?(\\d*x|\\d+)(\\^\\d+)?");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            Integer degree = 0;
            double coefficient = 1.0;

            String sign = matcher.group(1);

            if(sign != null && sign.equals("-")) {
                coefficient *= -1.0;
            }

            String stringCoefficient = matcher.group(2);

            if(!stringCoefficient.equals("x")) {
                String nextCoefficient = stringCoefficient;
                if(stringCoefficient.contains("x")) {
                    nextCoefficient = stringCoefficient.substring(0, stringCoefficient.length() - 1);
                }
                coefficient *= Double.parseDouble(nextCoefficient);
            }

            String stringDegree = matcher.group(3);

            if(stringDegree != null) {
                stringDegree = stringDegree.substring(1);
                degree = Integer.parseInt(stringDegree);
            } else if(stringCoefficient.charAt(stringCoefficient.length() - 1) == 'x') {
                degree = 1;
            } else {
                degree = 0;
            }

            newPolynomial.addMonomial(new Monomial(degree, coefficient));
        }
        return newPolynomial;
    }

}
