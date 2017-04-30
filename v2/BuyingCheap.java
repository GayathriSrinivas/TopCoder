
import org.apache.commons.lang.ArrayUtils;
import java.util.*;

/**
 * Created by gayathsr on 4/20/17.
 */
public class BuyingCheap {

    SortedSet<Integer> treeSet = new TreeSet<>();

    private static final int THIRD_HIGHEST = 3;
    private static final int ERROR_CASE = -1;

    public int thirdBestPrice(int[] prices) {
        treeSet.addAll(Arrays.asList(ArrayUtils.toObject(prices)));
        return  (treeSet.size() < THIRD_HIGHEST) ? ERROR_CASE : ((Integer[]) treeSet.toArray())[3];
    }

    public static void main(String args[]) {
        BuyingCheap buyingCheap = new BuyingCheap();
        int[] prices = {10, 10, 10, 10, 20, 20, 30, 30, 40, 40};
        System.out.println(buyingCheap.thirdBestPrice(prices));
    }
}
