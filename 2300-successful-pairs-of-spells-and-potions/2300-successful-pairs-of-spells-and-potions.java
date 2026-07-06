import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int m = potions.length;
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i]; // ceil(success / spell)

            int left = 0, right = m - 1;
            int idx = m; // Default: no valid potion found

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (potions[mid] >= need) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - idx;
        }
        return ans;
    }
}
