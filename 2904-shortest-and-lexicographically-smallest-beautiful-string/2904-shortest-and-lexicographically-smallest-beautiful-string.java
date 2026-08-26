class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < n; right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // When we have exactly k ones,
            // try to make the window as small as possible.
            while (ones == k) {

                String current = s.substring(left, right + 1);

                // Update answer:
                // 1. Shorter length is better
                // 2. Same length -> lexicographically smaller
                if (ans.equals("")
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                            && current.compareTo(ans) < 0)) {
                    ans = current;
                }

                // Remove left character
                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }
        }

        return ans;
    }
}