

import java.util.Arrays;

/**
 * Created by gayathsr on 4/29/17.
 */
public class SentenceDecomposition {

    int[] memo;

    public int decompose(String sentence, String[] validWords) {
        memo = new int[sentence.length() + 1];
        Arrays.fill(memo, -1);

        int cost = decomposeString(sentence, 0, validWords);
        return (cost == Integer.MAX_VALUE) ? -1 : cost;
    }

    private int decomposeString(String sentence, int index, String[] validWords) {
        if(memo[index] == -1) {
            if (index == sentence.length()) {
                return 0;
            }

            int minCost = Integer.MAX_VALUE;

            for (int i = 0; i < validWords.length; i++) {

                int cost = mismatchCost(validWords[i], sentence, index);

                if (cost != Integer.MAX_VALUE) {

                    int cost1 = decomposeString(sentence, index + validWords[i].length(), validWords);
                    if (cost1 != Integer.MAX_VALUE) {
                        cost = cost + cost1;

                        if (cost < minCost) {
                            minCost = cost;
                        }
                    }
                }
            }
            memo[index] = minCost;
        }

        return memo[index];

    }

    private int mismatchCost(String validWord, String sentence, int index) {
        int strlength = validWord.length();
        String targetString;
        try {
            targetString = sentence.substring(index, index + strlength);
        } catch (Exception ex) {
            return Integer.MAX_VALUE;
        }

        if (sameChars(validWord, targetString)) {
            int countMismatch = 0;

            for (int i = 0; i < validWord.length(); i++) {
                if (validWord.charAt(i) != targetString.charAt(i)) {
                    countMismatch++;
                }
            }

            return countMismatch;

        } else {
            return Integer.MAX_VALUE;
        }

    }

    private boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }


    public static void main(String args[]) {
        SentenceDecomposition sentenceDecomposition = new SentenceDecomposition();
        String sentence = "ommwreehisymkiml";
        String[] validWords = {"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"};
        System.out.println(sentenceDecomposition.decompose(sentence, validWords));
    }
}
