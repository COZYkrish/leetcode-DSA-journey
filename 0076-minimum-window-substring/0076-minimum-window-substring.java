class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) {
            targetCounts[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int requiredCount = t.length();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (targetCounts[rightChar] > 0) {
                requiredCount--;
            }
            targetCounts[rightChar]--;
            while (requiredCount == 0) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                targetCounts[leftChar]++;
                if (targetCounts[leftChar] > 0) {
                    requiredCount++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}