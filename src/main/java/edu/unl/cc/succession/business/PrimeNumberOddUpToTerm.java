package edu.unl.cc.succession.business;

public class PrimeNumberOddUpToTerm extends PrimeNumber{
    public PrimeNumberOddUpToTerm(Integer limit){
        super(limit);
    }

    public PrimeNumberOddUpToTerm(Integer start, Integer limit){
        super(start, limit);
    }

    @Override
    public Number calculate() {
        int exponent = 1;
        double result = 0;
        int countTerm = 0;
        while(countTerm < limit){
            this.printableTerms.append(currentTerm).append("^")
                    .append(exponent).append(" +");
            result += (long) Math.pow(currentTerm, 3);
            currentTerm = nextTerm(currentTerm).intValue();
            exponent += 2;
            countTerm++;
        }
        return result;
    }
}
