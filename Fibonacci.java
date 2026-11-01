
import java.util.Scanner;

public class Fibonacci {

    // Non-recursive method
    static void iterative(int n) {
        int a = 0, b = 1;

        System.out.print("Iterative: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int next = a + b; // Calculate next number
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Recursive method to find the nth Fibonacci number
    static int fib(int n) {
        if (n <= 1) {
            return n; // Base case
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        iterative(n);

        System.out.print("Recursive: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

        sc.close();
    }
}
