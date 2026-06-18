package edu.unl.cc.succession;

import edu.unl.cc.succession.business.*;
import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Succesionable;

import java.util.Scanner;

/**
 * @author Matias Romero, Freddy Ordoñez, Luis Armijos, Ezequiel Chamba, Arlette Quezada
 */

public class Main {
    private static void printMenu(){
        System.out.println("CALCULADORA DE SERIES");
        System.out.println("0. Salir del programa");
        System.out.println("1. Serie de numeros pares hasta un limite (S = 2 + 4 + 6 + 8 + ... N): ");
        System.out.println("2. Serie de primos elevados al cubo  hasta un limite (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ... + N^3): ");
        System.out.println("3. Serie de primos elevados al cubo  hasta N términos (S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ...):  ");
        System.out.println("4. Serie de primos elevados por pares hasta un limite (S = 1^2 + 3^4 + 5^6 + 7^8 + 11^10 + 13^(12) ... + N):");
        System.out.println("5. Serie de primos elevados a impares hasta n térmimos (S = S = 1^1 + 3^3 + 5^5 + 7^7 + 11^9 + 13^11 ..):");
        System.out.println("6. Serie de primos elevados a la raiz de numeros pares hasta un limite (S = 1^(1/2) + 3^(1/4) + 5^(1/6) + 7^(1/8) + 11^(1/10) + 13^(1/12) ... + N): ");
        System.out.println("7. Serie de primos elevados a la raiz de numeros impares hasta un n términos (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11)): ");
        System.out.println("8. Serie de primos elevados a la raiz cúbica hasta un n términos (S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3)): ");
        System.out.println("9. Serie de primos elevados a la raiz cuadrada hasta un limite (S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2)+ .. + N^(1/2): ");
        System.out.println("10. Serie de primos hasta un limite (S = 1 + 2 + 3 + 5 + 7 + 11 + 13 + .. + N: ");
    }

    private static int readOption(Scanner scanner){
        int option;
        printMenu();
        System.out.print("Elija la opción que desee: ");
        option = scanner.nextInt();
        return option;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        do {
            Succesionable serie = null;
            option = readOption(scanner);
            if(option == 0){
                break;
            }
            int inferiorLimit = 0;
            int limit = 0;

            if(option >= 1 && option <= 10){
                System.out.print("Debe ingresar un limite/N términos: ");
                limit = scanner.nextInt();
                System.out.print("Desea ingresar un limite inferior? (1 = Si | 0 = No): ");
                int optionLimit = scanner.nextInt();
                while(optionLimit < 0 || optionLimit > 1){
                    System.out.print("Solo puede ingresar el valor de 1 o 0, ingrese la opcion nuevamente: ");
                    optionLimit = scanner.nextInt();
                }
                if (optionLimit == 1) {
                    System.out.print("Ingrese su limite inferior: ");
                    inferiorLimit = scanner.nextInt();
                }
            }
            scanner.nextLine();
            switch (option) {
                case (1): {
                    serie = new EvenNumberCalculatorUpToLimit(inferiorLimit, limit);
                    break;
                }
                case (2): {
                    serie = new PrimeNumberCubedUpToLimit(inferiorLimit, limit);
                    break;
                }
                case (3): {
                    serie = new PrimeNumberCubedUpToTerm(inferiorLimit, limit);
                    break;
                }
                case (4): {
                    serie = new PrimeNumberEvenUpToLimit(inferiorLimit, limit);
                    break;
                }
                case (5): {
                    serie = new PrimeNumberOddUpToTerm(inferiorLimit, limit);
                    break;
                }

                case (6): {
                    serie = new PrimeNumberWithPowEvenCalculatorUpToLimit(inferiorLimit, limit);
                    break;
                }

                case (7): {
                    serie = new PrimeNumberWithPowCalculatorWithTerm(inferiorLimit, limit);
                    break;
                }

                case (8): {
                    serie = new PrimeNumberWithPowCubicCalculatorWithTerm(inferiorLimit, limit);
                    break;
                }

                case (9): {
                    serie = new PrimeNumberWithPowSquaredCalculatorUpToLimit(inferiorLimit, limit);
                    break;
                }

                case (10): {
                    serie = new PrimeNumberCalculatorUpToLimit(inferiorLimit, limit);
                    break;
                }
                default: {
                    System.out.println("Opción inválida");
                }
            }
            if (serie != null) {
                Number result = serie.calculate();
                System.out.println(((Printable) serie).print());
                System.out.println("S = " + result + "\n");
            }
            System.out.print("Desea continuar en la calculadora?(1 = Si | 0 = No) ");
            option = scanner.nextInt();
            scanner.nextLine();
        }while(option != 0);
        System.out.print("Cerrando el programa...");
    }
}
