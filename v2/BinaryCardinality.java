

import java.util.*;

/**
 * Created by gayathsr on 4/25/17.
 */
public class BinaryCardinality {

    Map<Integer, List<Integer>> treeMap = new TreeMap<>();

    public int[] arrange(int[] numbers) {
        int[] arrange = new int[numbers.length];


        for (int i = 0; i < numbers.length; i++) {
            String binaryNumber = Integer.toString(numbers[i], 2);
            int count = 0;
            for (int j = 0; j < binaryNumber.length(); j++) {
                if (binaryNumber.charAt(j) == '1') {
                    count++;
                }
            }

            List<Integer> list;

            if (!treeMap.containsKey(count)) {
                list = new ArrayList<>();
                treeMap.put(count, list);
            }
            list = treeMap.get(count);
            list.add(numbers[i]);
            treeMap.put(count, list);
        }

        Iterator iter = treeMap.values().iterator();

        int j = 0;
        while (iter.hasNext()) {
            ArrayList<Integer> values = (ArrayList<Integer>) iter.next();

            Collections.sort(values);
            for (int i = 0; i < values.size(); i++) {
                arrange[j++] = values.get(i);
            }
        }

        return arrange;
    }

    public static void main(String args[]) {
        BinaryCardinality bc = new BinaryCardinality();
        int[] number = {31, 15, 7, 3, 2};
        System.out.println(Arrays.toString(bc.arrange(number)));
    }

}
