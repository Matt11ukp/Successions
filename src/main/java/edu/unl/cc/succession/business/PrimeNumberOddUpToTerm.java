package edu.unl.cc.succession.business;
/**
 * Representa la serie de numeros primos elevados a numeros impares con N terminos
 *  (S = S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + 13^11 ..):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

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
