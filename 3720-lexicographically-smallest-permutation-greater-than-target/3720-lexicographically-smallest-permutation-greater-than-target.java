class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String ans = solve(target, 0, freq);

        return ans == null ? "" : ans;
    }

    private String solve(String target, int pos, int[] freq) {

        // We matched the entire target.
        // Equal is NOT allowed.
        if (pos == target.length()) {
            return null;
        }

        int t = target.charAt(pos) - 'a';

        /*
         * OPTION 1:
         * Keep the current character equal to target[pos].
         */
        if (freq[t] > 0) {

            int[] nextFreq = freq.clone();
            nextFreq[t]--;

            String suffix = solve(target, pos + 1, nextFreq);

            if (suffix != null) {
                return (char) ('a' + t) + suffix;
            }
        }

        /*
         * OPTION 2:
         * Make the current character greater than target[pos].
         *
         * We choose the SMALLEST possible greater character
         * because we want the lexicographically smallest answer.
         */
        for (int c = t + 1; c < 26; c++) {

            if (freq[c] > 0) {

                int[] nextFreq = freq.clone();
                nextFreq[c]--;

                StringBuilder ans = new StringBuilder();

                // Current character
                ans.append((char) ('a' + c));

                // Once we are greater, the rest should be
                // as small as possible.
                for (int x = 0; x < 26; x++) {
                    while (nextFreq[x] > 0) {
                        ans.append((char) ('a' + x));
                        nextFreq[x]--;
                    }
                }

                return ans.toString();
            }
        }

        // No valid permutation from this position
        return null;
    }
}