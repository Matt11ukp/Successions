package edu.unl.cc.succession.business;

/**
 * Representa la serie de numeros primos elevados al cuadrado hasta un limite
 * (S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2)+ .. + N^(1/2):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public class PrimeNumberWithPowSquaredCalculatorUpToLimit extends PrimeNumber{

    public PrimeNumberWithPowSquaredCalculatorUpToLimit(Integer limit) {
        super(limit);
    }

    public PrimeNumberWithPowSquaredCalculatorUpToLimit(Integer start, Integer limit) {
        super(start, limit);
    }

    @Override
    public Number calculate() {
        double result = 0;
        final int numeratorExponent = 1;
        int denominatorExponent = 2;
        while(this.currentTerm <= this.limit){
            this.printableTerms.append(currentTerm).append("^(")
                    .append(numeratorExponent).append("/").append(denominatorExponent).append(") +");
            result = result + Math.pow(currentTerm, (double) numeratorExponent / denominatorExponent);

            currentTerm = nextTerm(currentTerm).intValue();
        }
        return result;
    }
}
