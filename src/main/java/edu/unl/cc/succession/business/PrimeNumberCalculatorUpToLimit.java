package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;


public class PrimeNumberCalculatorUpToLimit extends PrimeNumber {

    public PrimeNumberCalculatorUpToLimit(Integer limit) {
        super(limit);
    }

    public PrimeNumberCalculatorUpToLimit(Integer start, Integer limit) {
        super(start, limit);
    }

    @Override
    public Number calculate() {
        long result = 0;
        while(currentTerm <= limit){
            this.printableTerms.append(String.valueOf(currentTerm)).append(" + ");
            result += currentTerm;
            currentTerm = this.nextTerm(currentTerm).intValue();
        }
        return result;
    }
}
