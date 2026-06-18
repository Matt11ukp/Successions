package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;
/**
 * Representa la serie de numeros primos hasta un limite
 * S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + .. + N:
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

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
