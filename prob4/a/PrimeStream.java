package prob4.a;

import java.util.stream.Stream;

public class PrimeStream {

    public static void main(String[] args) {
        final Stream<Integer> primes = Stream.iterate(2, PrimeStream::nextPrime);

        // Print the first 20 primes for demonstration
        primes.limit(20).forEach(System.out::println);
    }

    // Method to find the next prime number after the given number
    private static int nextPrime(int current) {
        int next = current + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    // Method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

