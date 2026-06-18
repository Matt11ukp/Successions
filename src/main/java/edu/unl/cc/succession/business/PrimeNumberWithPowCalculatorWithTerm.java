package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;

/**
 * Representa la serie de numeros primos elevados a la raiz de impares con N terminos
 * (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11)):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public class PrimeNumberWithPowCalculatorWithTerm extends PrimeNumber {

    public PrimeNumberWithPowCalculatorWithTerm(Integer limit) {
        super(limit);
    }

    public PrimeNumberWithPowCalculatorWithTerm(Integer start, Integer limit) {
        super(start, limit);
    }

    @Override
    public Number calculate() {
        double result = 0;
        int countTerm = 0;
        final int numeratorExponent = 1;
        int denominatorExponent = 1;
        while(countTerm < limit){
            this.printableTerms.append(currentTerm).append("^(")
                    .append(numeratorExponent).append("/").append(denominatorExponent).append(") +");
            result = result + Math.pow(currentTerm, (double) numeratorExponent / denominatorExponent);

            currentTerm = nextTerm(currentTerm).intValue();
            denominatorExponent += 2;
            countTerm++;
        }
        return result;
    }

}

