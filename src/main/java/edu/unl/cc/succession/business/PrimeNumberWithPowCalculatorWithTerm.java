package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;

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

