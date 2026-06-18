package edu.unl.cc.succession.business;
/**
 * Representa la serie de numeros primos elevados a la raiz de numeros pares hasta un limite
 * (S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + 11^(1/10) + 13^(1/12) ... + N):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public class PrimeNumberWithPowEvenCalculatorUpToLimit extends PrimeNumber{

    public PrimeNumberWithPowEvenCalculatorUpToLimit(Integer limit) {
        super(limit);
    }

    public PrimeNumberWithPowEvenCalculatorUpToLimit(Integer start, Integer limit) {
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
            denominatorExponent += 2;
        }
        return result;
    }
}
