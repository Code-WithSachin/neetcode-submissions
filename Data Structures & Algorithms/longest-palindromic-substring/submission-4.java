class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        
        String longest = "";

        // Loop 1: The starting index of the substring
        for (int i = 0; i < n; i++) {
            
            // Loop 2: The ending index (exclusive, so it goes up to n)
            for (int j = i + 1; j <= n; j++) {
                
                // Extract the substring from index i to j-1
                String substring = s.substring(i, j);
                
                // If it's a palindrome and longer than our current best, update it
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }

        return longest;
    }

    // O(n) helper function to check if a standalone string is a palindrome
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}