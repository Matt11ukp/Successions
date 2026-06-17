package edu.unl.cc.succession.business;

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
