class Solution {
    public int uniqueXorTriplets(int[] nums) {

        boolean[] one = new boolean[2048];
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        for (int x : nums) {
            one[x] = true;
        }

        int n = nums.length;

        // XOR of two elements (repetition allowed)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                two[nums[i] ^ nums[j]] = true;
            }
        }

        // XOR of (two-element XOR) with one element
        for (int x = 0; x < 2048; x++) {
            if (!two[x]) continue;

            for (int num : nums) {
                three[x ^ num] = true;
            }
        }

        int ans = 0;
        for (boolean val : three) {
            if (val) ans++;
        }

        return ans;
    }
}