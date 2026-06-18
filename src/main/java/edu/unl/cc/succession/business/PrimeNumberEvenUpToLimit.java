package edu.unl.cc.succession.business;
/**
 * Representa la serie de numeros primos elevados a numeros pares hasta un limite
 * (S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + 13^(12) ... + N):
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

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
            result += (long) Math.pow(currentTerm, 3);
            currentTerm = nextTerm(currentTerm).intValue();
            exponent += 2;
        }
        return result;
    }
}
