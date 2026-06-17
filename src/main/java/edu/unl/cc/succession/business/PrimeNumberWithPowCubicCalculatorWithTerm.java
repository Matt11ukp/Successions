package edu.unl.cc.succession.business;

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
