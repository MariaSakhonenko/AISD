import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        if (K > N) {
            System.out.println(0);
            return;
        }

        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        long result = (factorial[N] * modInverse(factorial[K], MOD) % MOD) * modInverse(factorial[N - K], MOD) % MOD;
        System.out.println(result);
    }

    public static long modInverse(long a, long p) {
        return power(a, p - 2, p);
    }

    public static long power(long a, long b, long p) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = result * a % p;
            }
            a = a * a % p;
            b /= 2;
        }
        return result;
    }
}
