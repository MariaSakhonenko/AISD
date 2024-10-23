import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        int s = Integer.parseInt(reader.readLine().trim());
        int[] dimensions = new int[s + 1];

        for (int i = 0; i < s; i++) {
            String[] parts = reader.readLine().split(" ");
            int rows = Integer.parseInt(parts[0]);
            int cols = Integer.parseInt(parts[1]);
            if (i == 0) {
                dimensions[i] = rows;
            }
            dimensions[i + 1] = cols;
        }
        reader.close();

        int[][] dp = new int[s][s];
        for (int i = 0; i < s; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < s; i++) {
            dp[i][i] = 0;
        }

        for (int length = 2; length <= s; length++) {
            for (int i = 0; i <= s - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        writer.write(dp[0][s - 1] + "\n");
        writer.close();
    }
}
