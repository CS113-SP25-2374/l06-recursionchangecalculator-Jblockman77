package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();

        calcHelper(combinations, cents, 0, 0, 0, 0);
        return combinations;
    }

    public static void calcHelper(List<String> list, int cents, int penny, int nickel, int dime, int quater){

        if(cents == 0){
            String combo = combinationToString(quater, dime, nickel, penny);
            if(!list.contains(combo)){
                list.add(combo);
            }
        }

        if(cents >= 25){
            calcHelper(list, cents-25, penny, nickel, dime, quater+1);
            
        }
        if(cents >= 10){
            calcHelper(list, cents-10, penny, nickel, dime+1, quater);
        }
        if(cents >= 5){
            calcHelper(list, cents-5, penny, nickel+1, dime, quater);
        }
        if(cents >= 1){
            calcHelper(list, cents-1, penny+1, nickel, dime, quater);
        }
        
    }
}