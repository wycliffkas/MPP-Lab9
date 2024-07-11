package prob4.b;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrimeStream {

    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream(); // PrimeStream is the enclosing class
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }

    // Method to print the first n prime numbers
    public void printFirstNPrimes(long n) {
        Supplier<Stream<Integer>> primeSupplier = () -> Stream.iterate(2, PrimeStream::nextPrime);
        primeSupplier.get().limit(n).forEach(System.out::println);
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

