import java.util.HashMap;
import java.util.Map;

public class Grader {

	private static final int numOfGrades = 7;
	
    public int[] grade(int[] predictedGrades, int[] actualGrades) {
    	int[] results = new int[7];
    	int countGrades = predictedGrades.length;
    	Map<Integer, Integer> grades = new HashMap<Integer, Integer>();
    	populateMap(grades);
    	
    	for (int i = 0; i < countGrades; i++) {
			int diff = Math.abs(predictedGrades[i] - actualGrades[i]);
			int count = grades.get(diff);
			count += 1;
			grades.put(diff,count);
		}
    	
    	for (int i = 0; i < results.length; i++) {
			results[i] = (int) Math.floor((float)(grades.get(i) * 100) / countGrades);
		}

    	return results;
    }

	private void populateMap(Map<Integer, Integer> grades) {
		for (int i = 0; i < numOfGrades ; i++) {
			grades.put(i, 0);
		}
	}
	
	 public static void main(String[] args) {
	        Grader grader = new Grader();
	        int[] var_0_0 = {1,5,7,3};
	        int[] var_0_1 = {3,5,4,5};
	        int[] expected_0 = grader.grade(var_0_0,var_0_1);
	        Utils.printArray(expected_0);
	        
	        int[] var_1_0 = {1,1,1};
	        int[] var_1_1 = {5,6,7};
	        int[] expected_1 = grader.grade(var_1_0,var_1_1);
	        Utils.printArray(expected_1);
	        
	        int[] var_2_0 = {3};
	        int[] var_2_1 = {3};
	        int[] expected_2 = grader.grade(var_2_0,var_2_1);
	        Utils.printArray(expected_2);
	        
	        int[] var_3_0 = {1,5,3,5,6,4,2,5,7,6,5,2,3,4,1,4,6,5,4,7,6,6,1};
	        int[] var_3_1 = {5,1,3,2,6,4,1,7,5,2,7,4,2,6,5,7,3,1,4,6,3,1,7};
	        int[] expected_3 = grader.grade(var_3_0,var_3_1);
	        Utils.printArray(expected_3);
	 }
	
}
