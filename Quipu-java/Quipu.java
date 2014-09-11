//SRM 155 DIV 2
public class Quipu {

    public int readKnots(String knots) {
    	int stringLength = knots.length();
		
		if(knots.charAt(stringLength - 1) == '-') {
			knots = knots.substring(1,stringLength - 1);
		} else {
			knots = knots.substring(1, stringLength - 2);
		}
			
		StringBuffer result = new StringBuffer();
		String[] array = knots.split("-", knots.length() );
		for (int i = 0; i < array.length; i++) { 
			result.append(array[i].length());
		}
		
		return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        Quipu quipu = new Quipu();
        String var_0_0 = "-XX-XXXX-XXX-";
        int expected_0 = quipu.readKnots(var_0_0);
        System.out.println(((expected_0 == 243) ? "Passed" : "Failed") + " for case 0");
        String var_1_0 = "-XX--XXXX---XXX-";
        int expected_1 = quipu.readKnots(var_1_0);
        System.out.println(((expected_1 == 204003) ? "Passed" : "Failed") + " for case 1");
        String var_2_0 = "-X-";
        int expected_2 = quipu.readKnots(var_2_0);
        System.out.println(((expected_2 == 1) ? "Passed" : "Failed") + " for case 2");
        String var_3_0 = "-X-------";
        int expected_3 = quipu.readKnots(var_3_0);
        System.out.println(((expected_3 == 1000000) ? "Passed" : "Failed") + " for case 3");
        String var_4_0 = "-XXXXXXXXX--XXXXXXXXX-XXXXXXXXX-XXXXXXX-XXXXXXXXX-";
        int expected_4 = quipu.readKnots(var_4_0);
        System.out.println(((expected_4 == 909979) ? "Passed" : "Failed") + " for case 4");

    }

}


