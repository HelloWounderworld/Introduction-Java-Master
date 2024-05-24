/**
* This class Generates prime numbers up to a user s@ecified maximum.
* The algorithm used is the Sieve of Eratosthenes.
* Given an array of integers starting at 2.
* Find the first uncrossed integer, and cross out all its multiples
* Repeat until there are no more multiples in the array.
* URL: https://pt.wikipedia.org/wiki/Crivo_de_Erat%C3%B3stenes#:~:text=O%20Crivo%20de%20Erat%C3%B3stenes%20%C3%A9,at%C3%A9%20um%20certo%20valor%20limite.
*/

public class PrimerGenerator
{
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if(maxValue < 2) return new int[0];
        else {
            uncossIntegerUpTo(maxValue):
            crossOutMultiples();
            putUncrossedIntegersIntpResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }

    private static void crossOutMultiples() {
        int limit = determineInterationLimit();
        for (int i = 2; i <= limit; i++) {
            if(notCrossed(i)) crossOutMultiplesOf(i);
        }
    }

    private static int determineInterationLimit() {
        //Every multiple in the array has a prime factor that
        // is less than or equal to the root of the array size,
        // so we don't have to cross out multiples of numbers
        // larger than that root.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2*i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++) {
            if(notCrossed(i)) result[j++] = i;
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if(notCrossed(i)) count++;
        }

        return count;
    }
}