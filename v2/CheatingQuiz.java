import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gayathsr on 4/23/17.
 */
public class CheatingQuiz {

    Map<Character, Integer> aggregate = new HashMap<>();

    public int[] howMany(String answers) {

        Integer count;
        Character key;
        for (int i = 0; i < answers.length(); i++) {
            key = answers.charAt(i);
            count = aggregate.containsKey(key) ? aggregate.get(key) : 0;
            aggregate.put(key, ++count);
        }

        int[] results = new int[answers.length()];

        for (int i = 0; i < answers.length(); i++) {
            results[i] = aggregate.size();

            key = answers.charAt(i);
            count = aggregate.get(key);
            aggregate.put(key, --count);

            if (count == 0) {
                aggregate.remove(key);
            }
        }

        return results;
    }


    public static void main(String args[]) {
        CheatingQuiz cheatingQuiz = new CheatingQuiz();
        String answer = "BACACABCBBBBCAAAAACCCABBCAA";
        System.out.println(Arrays.toString(cheatingQuiz.howMany(answer)));
    }
}
