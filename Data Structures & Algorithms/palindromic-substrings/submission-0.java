class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int totalPalindromes = 0;

        for (int i = 0; i < n; i++) {
            // Case 1: Count odd-length palindromes (e.g., "aba")
            totalPalindromes += expandAndCount(i, i, s);
            
            // Case 2: Count even-length palindromes (e.g., "abba")
            totalPalindromes += expandAndCount(i, i + 1, s);
        }

        return totalPalindromes;
    }

    // Pure function: Expands out, counts matches, returns an integer
    private int expandAndCount(int start, int end, String s) {
        int count = 0;
        
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;   // We found a valid palindrome! Increment the count.
            start--;   // Move left pointer out
            end++;     // Move right pointer out
        }
        
        return count;
    }
}