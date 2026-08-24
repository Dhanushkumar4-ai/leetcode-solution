class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Calculate prefix sums
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Base case
        int ans = stones[n - 1];

        // DP from right to left
        for (int i = n - 2; i >= 1; i--) {
            ans = Math.max(ans, stones[i] - ans);
        }

        return ans;
    }
}