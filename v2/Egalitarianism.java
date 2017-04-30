

import java.util.*;

/**
 * Created by gayathsr on 4/25/17.
 */
public class Egalitarianism {

    Map<Citizen, List<Integer>> map = new HashMap<>();

    public int maxDifference(String[] isFriend, int d) {


        for (int i = 0; i < isFriend.length ; i++) {
            Citizen c = new Citizen(false, Integer.MIN_VALUE, i);
            String population = isFriend[i];
            List<Integer> list = null;
            for (int j = 0; j < population.length(); j++) {
                if(population.charAt(j) == 'Y') {
                    if(list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(j);
                }
            }
            map.put(c, list);
        }

        int maxDiff = 0;

        int totalCount = 0;
        int[] results = new int[map.size()];

        for (int k = 0; k < map.size(); k++) {
            totalCount =0;
            Queue<Citizen> queue = new LinkedList<>();
            Citizen c2 = findByNumber(map, k);
            c2.value = 0;
            queue.add(c2);
            c2.addedToQueue = true;

            int numOfCitizend = k;

            while(!queue.isEmpty()) {
                totalCount++;
                Citizen c = queue.remove();
                c.isVisisted = true;
                if(c.value == Integer.MIN_VALUE) {
                    c.value = maxDiff;
                }
                List<Integer> friends = map.get(c);

                boolean flag = true;
                if(friends!=null) {
                    for (int i = 0; i < friends.size(); i++) {
                        Citizen c1 = findByNumber(map, friends.get(i));
                        if (c1 != null && c1.isVisisted == false && c1.addedToQueue == false) {
                            if (flag) {
                                maxDiff = c.value + d;
                                flag = false;
                            }
                            c1.value = maxDiff;
                            queue.add(c1);
                            c1.addedToQueue = true;
                        }
                    }
                }
            }

            int max = 0;
            for (Citizen c: map.keySet()) {
                if(c.value > max) {
                    max = c.value;
                }
            }

            results[k] = max;

            resetValues(map, results.length);

        }



        if(totalCount != isFriend[0].length()) {
            return -1;
        }


        Arrays.sort(results);

        return results[map.size() - 1];

    }

    private void resetValues(Map<Citizen, List<Integer>> map, int n ) {

        for (int i = 0; i < n; i++) {
            Citizen c = findByNumber(map, i);
            c.isVisisted = false;
            c.value = Integer.MIN_VALUE;
            c.addedToQueue = false;
        }

    }

    public Citizen findByNumber(Map<Citizen, List<Integer>>  citizens, int number) {

        Set<Citizen> setCitizens = citizens.keySet();

        Iterator<Citizen> iter = setCitizens.iterator();

        while(iter.hasNext()) {
            Citizen c = iter.next();
            if(c.number == number) {
                return c;
            }
        }

        return null;
    }

    public static void main(String args[]) {
        Egalitarianism e = new Egalitarianism();
//        String[] isFriend = {"NYNYYYN", "YNNYYYN", "NNNNYNN", "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN"};
//        int d = 5;
//        System.out.println(e.maxDifference(isFriend, d));
        String[] isFriend1 = {"NYYNNNNYYYYNNNN", "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN", "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN", "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY", "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN", "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN"};
        int d1 = 747  ;
        System.out.println(e.maxDifference(isFriend1, d1));
    }
}

class Citizen {
    boolean isVisisted;
    int value;
    int number;
    boolean addedToQueue;

    public Citizen (boolean isVisisted, int value, int number) {
        this.isVisisted = isVisisted;
        this.value = value;
        this.number = number;
        this.addedToQueue = false;
    }
}
