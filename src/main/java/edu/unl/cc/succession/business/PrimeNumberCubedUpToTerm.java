package edu.unl.cc.succession.business;

public class PrimeNumberCubedUpToTerm extends PrimeNumber {

    public PrimeNumberCubedUpToTerm(Integer limit){
        super(limit);
    }

    public PrimeNumberCubedUpToTerm(Integer start, Integer limit){
        super(start, limit);
    }

    @Override
    public Number calculate() {

        double result = 0;
        int countTerm = 0;
        while(countTerm < limit){
            this.printableTerms.append(currentTerm).append("^")
                    .append("3").append(" +");
            result += (long) Math.pow(currentTerm, 3);
            currentTerm = nextTerm(currentTerm).intValue();
            countTerm++;
        }
        return result;
    }

}
