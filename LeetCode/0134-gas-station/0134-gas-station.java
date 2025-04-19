class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (!checkSum(gas, cost)) return -1;

        int gasSum = 0;
        int gasIdx = 0;
        int costIdx = 0;
        while (gasIdx < gas.length) {
            if (gas[gasIdx] < cost[costIdx]) {
                gasSum += gas[gasIdx++];
                costIdx = 0;
            } else {
                gasSum += gas[gasIdx++] - cost[costIdx++];
            }
        }

        if (gasSum < 0) {
            return -1;
        }

        System.out.println(gasIdx);
        System.out.println(costIdx);
        return costIdx;
    }

    private boolean checkSum(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        return gasSum == costSum;
    }
}