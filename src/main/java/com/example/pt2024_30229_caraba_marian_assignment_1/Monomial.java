package com.example.pt2024_30229_caraba_marian_assignment_1;

public class Monomial {
    private Integer degree;

    private double coefficient;

    public Integer getDegree() {
        return degree;
    }

    public double getCoefficient() { return coefficient; }


    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Monomial(Integer degree, double coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public Monomial divideMonomial(Monomial divisor) {
        Integer degree = this.degree - divisor.degree;
        double coefficient = this.coefficient / divisor.coefficient;
        return new Monomial(degree, coefficient);
    }
}
