import java.util.*;
class MinCostClimbingStairs {
    static Map<Integer, Integer> store = new HashMap<Integer, Integer>();
    public static int minCostClimbingStairs(int[] cost) {
        return minCost(cost, cost.length);
    }
    private static int minCost(int[] cost, int n) {
        if (n == 1 || n == 0)
            return 0;
        if (store.containsKey(n))
            return store.get(n);
        int min = Math.min(cost[n-1] + minCost(cost, n-1), cost[n-2] + minCost(cost, n-2));
        store.put(n, min);
        return min;
    }

    public static void main(String[] args) {
    	int[] cost = new int[]{0,0,1,1};
       	System.out.println(minCostClimbingStairs(cost));
    }
}