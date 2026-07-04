class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;
        int left = 0;
        int right = n - 1;
        while (left < candidates && left <= right) {
            leftHeap.offer(costs[left]);
            left++;
        }
        while (right >= n - candidates && left <= right) {
            rightHeap.offer(costs[right]);
            right--;
        }
        long ans = 0;
        while (k-- > 0) {
            if (rightHeap.isEmpty() ||
                (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {

                ans += leftHeap.poll();

                if (left <= right) {
                    leftHeap.offer(costs[left]);
                    left++;
                }

            } else {

                ans += rightHeap.poll();

                if (left <= right) {
                    rightHeap.offer(costs[right]);
                    right--;
                }
            }
        }

        return ans;
    }
}