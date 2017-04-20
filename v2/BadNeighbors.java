
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * A[0..n] = Max {a[0] + A[2..n], A[1..n]}
 * <p>
 * A[n] = a[n]
 * A[empty] = 0
 */
public class BadNeighbors {

    Map<Pair<Integer, Boolean>, Integer> memoizedResults = new HashMap<>();

    int best(int[] arr, int i, boolean firstIncluded) {

        Pair<Integer, Boolean> key = new Pair<>(i, firstIncluded);

        if (!memoizedResults.containsKey(key)) {

            if (i == arr.length - 1) {
                return firstIncluded ? 0 : arr[i];
            }

            if (i == arr.length) return 0;

            int v1 = arr[i] + best(arr, i + 2, i == 0 ? true : firstIncluded);

            int v2 = best(arr, i + 1, i == 0 ? false : firstIncluded);

            memoizedResults.put(key, Math.max(v1, v2));
        }

        return memoizedResults.get(key);
    }

    public int maxDonations(int[] donations) {
        return best(donations, 0, true);
    }

    public static void main(String args[]) {
        BadNeighbors b = new BadNeighbors();
        int[] a = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        System.out.println(b.maxDonations(a));
    }
}
