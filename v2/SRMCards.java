

import java.util.*;

/**
 * Created by gayathsr on 4/29/17.
 */
public class SRMCards {


    public int maxTurns(int[] cards) {

        //Arrays.sort(cards);

        Integer[] integercards = new Integer[cards.length];
        int i = 0;
        for (int value : cards) {
            integercards[i++] = Integer.valueOf(value);
        }

        Set<Integer> cardsSet = new TreeSet<>(Arrays.asList(integercards));
        Iterator iter = cardsSet.iterator();
        int count = 0;


        while (iter.hasNext()) {
            Integer element = (Integer) iter.next();

            if(cardsSet.contains(element - 1)){
                cardsSet.remove(element - 1);
            }

            if(cardsSet.contains(element + 1)){
                cardsSet.remove(element + 1);
            }

            cardsSet.remove(element);

            iter = cardsSet.iterator();

            count++;
        }

        return count;
    }

    public static void main(String args[]) {
        SRMCards srm = new SRMCards();
        int cards[] = {118, 321, 322, 119, 120, 320};
        srm.maxTurns(cards);
    }
}
