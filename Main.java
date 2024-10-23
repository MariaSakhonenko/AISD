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

        System.out.println(binomialCoeff(N, K));
    }

    public static long binomialCoeff(int N, int K) {
        if (K > N - K) {
            K = N - K;  // Use symmetry property
        }
        long[] dp = new long[K + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = Math.min(i, K); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return dp[K];
    }
}
