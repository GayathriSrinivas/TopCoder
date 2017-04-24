
import java.util.Arrays;

public class ColorfulRoad {

    int[] memo;

    int memoizedCount;

    public int getMin(String road) {
        memo = new int[road.length()];

        Arrays.fill(memo, -1);

        int minCost = getMinCost(road, 0);
        System.out.println(memoizedCount);
        return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
    }

    private int getMinCost(String road, int currentIndex) {

        if (memo[currentIndex] == -1) {

            memoizedCount++;
            if (currentIndex == road.length() - 1) {
                return 0;
            }

            char currentColor = road.charAt(currentIndex);
            char targetColor = (currentColor == 'R') ? 'G' : ((currentColor == 'G') ? 'B' : 'R');

            int minCost = Integer.MAX_VALUE;

            for (int targetIndex = currentIndex + 1; targetIndex < road.length(); targetIndex++) {
                if (road.charAt(targetIndex) == targetColor) {
                    int minCostFromCurrentIndex = getMinCost(road, targetIndex);
                    if (minCostFromCurrentIndex != Integer.MAX_VALUE) {
                        int currentValue = (int) (Math.pow(targetIndex - currentIndex, 2) + minCostFromCurrentIndex);
                        if (currentValue < minCost) {
                            minCost = currentValue;
                        }
                    }
                }
            }

            memo[currentIndex] = minCost;
        }

        return memo[currentIndex];
    }

    public static void main(String args[]) {
        ColorfulRoad colorfulRoad = new ColorfulRoad();
        String road = "RBRGBGBGGBGRGGG";
        System.out.println(colorfulRoad.getMin(road));
    }
}
