class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0,1);
            }
        }

        int low, high;
        String charMax = "";
        for (int i = 1; i < s.length(); i++) {
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high <= s.length()-1 && s.charAt(low) == s.charAt(high)) { //finds odd palindromes
                if (s.substring(low, high+1).length() > charMax.length()) {
                    charMax = s.substring(low, high+1);
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) { //finds even palindromes
                if (s.substring(low, high+1).length() > charMax.length()) {
                    charMax = s.substring(low, high+1);
                }

                low = low-1;
                high = high+1;
            }
        }
        if (charMax == "") {
            return s.substring(0,1);
        } else {
            return charMax;
        }
    }
}