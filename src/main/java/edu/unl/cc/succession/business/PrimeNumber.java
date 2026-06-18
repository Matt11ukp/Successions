package edu.unl.cc.succession.business;

import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;

/**
 * Clase abstracta que brinda los metodos para hacer que la base de las potencias sean primos
 * de esta clase heredan las demas para implementar su calculo a su manera
 * los constructores permiten que haya un comienzo si se desea, o que sea 0
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public abstract class PrimeNumber implements Succesionable, Printable {
    protected Integer limit;
    protected Integer currentTerm;
    protected StringBuilder printableTerms;

    public PrimeNumber(Integer limit){
        this(0, limit);
    }

    public PrimeNumber(Integer start, Integer limit){
        start = validateLimit(start, "Down limit");
        setLimit(limit);
        this.currentTerm = nextTerm(start - 1).intValue();
        printableTerms = new StringBuilder("S = ");
    }

    public PrimeNumber() {
    }

    Integer validateLimit(Number value, String label){
        if(value == null){
            throw  new IllegalArgumentException(label + " cannot be null");
        }
        if(value instanceof Integer){
            if(value.intValue() < 0){
                throw new IllegalArgumentException(label + " Limit cannot be negative");
            }
            return value.intValue();
        } else{
            throw new IllegalArgumentException(label + " Limit must be an integer");
        }
    }

    @Override
    public void setLimit(Number limit) {
        this.limit = validateLimit(limit, "Upper Limit");
    }

    @Override
    public Number calculate() {
        return limit;
    }

    @Override
    public Number nextTerm(Number current) {
        current = current.intValue() + 1;
        boolean isPrime = false;
        while(!isPrime){
            isPrime = isPrime(current.intValue());
            if(!isPrime){
                current = current.intValue() + 1;
            }
        }
        return current;
    }

    boolean isPrime(Integer number){
        // el 1 y el propio numero no entran en el for, por lo que solo evalua si es divisible
        // para cualquier otro numero, si lo es, no es primo y retorna falso
        if (number < 2) {
            return false;
        }

        for(int i = 2; i < number; i++){
                if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}
