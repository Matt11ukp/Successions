package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;

public class PrimeNumberCubedUpToLimit extends PrimeNumber {

    public PrimeNumberCubedUpToLimit(Integer limit){
        super(limit);
    }

    public PrimeNumberCubedUpToLimit(Integer start, Integer limit){
        super(start, limit);
    }

    @Override
    public Number calculate() {

        double result = 0;
        while(this.currentTerm <= this.limit){
            this.printableTerms.append(currentTerm).append("^")
                    .append("3").append(" +");
            result = (long) Math.pow(currentTerm, 3);
            currentTerm = nextTerm(currentTerm).intValue();
        }
        return result;
    }

}
