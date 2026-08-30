class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalSurplus += netGas;
            currentSurplus += netGas;            
            if (currentSurplus < 0) {
                startIndex = i+1;
                currentSurplus = 0;
            }
        }
        
        return totalSurplus >= 0 ? startIndex : -1;
    }
}