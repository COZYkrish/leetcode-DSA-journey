import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }
        Map<String, Integer> targetCount = new HashMap<>();
        for (String w : words) {
            targetCount.put(w, targetCount.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> windowCount = new HashMap<>();
            int matchedWords = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (targetCount.containsKey(sub)) {
                    windowCount.put(sub, windowCount.getOrDefault(sub, 0) + 1);
                    matchedWords++;
                    while (windowCount.get(sub) > targetCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        matchedWords--;
                        left += wordLen;
                    }
                    if (matchedWords == wordCount) {
                        result.add(left);
                    }
                } else {
                    windowCount.clear();
                    matchedWords = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}