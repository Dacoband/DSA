package DynamicProgramming.EggDropping;

public class EggDropSolver {
    public static int minDroppings(Egg[] eggs, Building building) {
        int eggsCount = eggs.length;
        int floors = building.getFloors();

        // Mảng dp có kích thước (eggsCount + 1) x (floors + 1)
        int[][] dp = new int[eggsCount + 1][floors + 1];

        for (int i = 1; i <= eggsCount; i++) {
            for (int j = 1; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k <= j; k++) {
                    int res = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);

                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }

        return dp[eggsCount][floors];
    }
}
