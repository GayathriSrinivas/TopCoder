
import java.util.HashMap;
import java.util.Map;

public class RGBStreet {

    Map<String, Integer> memo = new HashMap<>();
    public int count = 0;

    private int minCost(String[] houses, int houseNumber, boolean rAllowed, boolean gAllowed, boolean bAllowed) {

        String key = "" + houseNumber + rAllowed + gAllowed + bAllowed;

        if(!memo.containsKey(key)) {
            count++;
            if( houseNumber == houses.length) {
                return 0;
            }

            int redCost = Integer.MAX_VALUE, blueCost = Integer.MAX_VALUE, greenCost = Integer.MAX_VALUE;

            if(rAllowed) {
                redCost = Integer.parseInt(houses[houseNumber].split(" ")[0]) + minCost(houses, houseNumber + 1, false, true, true);
            }
            if(gAllowed) {
                greenCost = Integer.parseInt(houses[houseNumber].split(" ")[1]) + minCost(houses, houseNumber + 1, true, false, true);
            }
            if(bAllowed) {
                blueCost = Integer.parseInt(houses[houseNumber].split(" ")[2]) + minCost(houses, houseNumber + 1, true, true, false);
            }

            memo.put(key,Math.min(Math.min(redCost, greenCost), blueCost));
        }

        return memo.get(key);
    }

    int estimateCost(String[] houses) {
        return minCost(houses, 0, true, true, true);
    }

    public static void main(String args[]) {
        RGBStreet rgbStreet = new RGBStreet();
        String[] houses = {"71 39 44", "32 83 55", "51 37 63", "89 29 100", "83 58 11", "65 13 15", "47 25 29", "60 66 19"};
        System.out.println(rgbStreet.estimateCost(houses));

        System.out.println("Number " + rgbStreet.count);
    }
}
