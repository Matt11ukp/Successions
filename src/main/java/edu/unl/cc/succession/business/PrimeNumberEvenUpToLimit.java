package edu.unl.cc.succession.business;

public class PrimeNumberEvenUpToLimit extends PrimeNumber{

    public PrimeNumberEvenUpToLimit(Integer limit){
        super(limit);
    }

    public PrimeNumberEvenUpToLimit(Integer start, Integer limit){
        super(start, limit);
    }

    @Override
    public Number calculate() {
        int exponent = 2;
        double result = 0;
        while(this.currentTerm <= this.limit){
            this.printableTerms.append(currentTerm).append("^")
                    .append(exponent).append(" +");
            result = (long) Math.pow(currentTerm, 3);
            currentTerm = nextTerm(currentTerm).intValue();
            exponent += 2;
        }
        return result;
    }
}
