package edu.unl.cc.succession.business;
/**
 * Representa la serie de numeros primos elevados a la raiz cubica con N terminos
 *  (S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3)):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public class PrimeNumberWithPowCubicCalculatorWithTerm extends PrimeNumber{

    public PrimeNumberWithPowCubicCalculatorWithTerm(Integer limit) {
        super(limit);
    }

    public PrimeNumberWithPowCubicCalculatorWithTerm(Integer start, Integer limit) {
        super(start, limit);
    }

    @Override
    public Number calculate() {
        double result = 0;
        int countTerm = 0;
        final int numeratorExponent = 1;
        int denominatorExponent = 3;
        while(countTerm < limit){
            this.printableTerms.append(currentTerm).append("^(")
                    .append(numeratorExponent).append("/").append(denominatorExponent).append(") +");
            result = result + Math.pow(currentTerm, (double) numeratorExponent / denominatorExponent);

            currentTerm = nextTerm(currentTerm).intValue();
            countTerm++;
        }
        return result;
    }
}
