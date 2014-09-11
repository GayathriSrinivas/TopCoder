//SRM 244 DIV 2
public class PhonePad {

	private static final int NUM_DIGITS_PER_ROW = 3;
	
    public int fingerMovement(String phoneNumber) {

    	String pad = "123456789*0#";
    	int result = 0;
    	
    	/*Following Manhattan Distance: distance = (x1-x2) + (y1-y2);
    	(x,y) is set (1,1) as the starting position of the hand in 5
    	*/    	
    	int x = 1;
    	int y = 1;
    	
    	for (int i = 0; i < phoneNumber.length(); i++) {
		
    		int index = pad.indexOf(phoneNumber.charAt(i));
    		int row = index / NUM_DIGITS_PER_ROW;
    		int col = index % NUM_DIGITS_PER_ROW;
    		result += Math.abs(x - row) + Math.abs(y-col);
    		x = row;
    		y = col;
		}

    	return result;
    }

    public static void main(String[] args) {
        PhonePad phonepad = new PhonePad();
        String var_0_0 = "911";
        int expected_0 = phonepad.fingerMovement(var_0_0);
        System.out.println(((expected_0 == 6) ? "Passed" : "Failed") + " for case 0");
        String var_1_0 = "5555555";
        int expected_1 = phonepad.fingerMovement(var_1_0);
        System.out.println(((expected_1 == 0) ? "Passed" : "Failed") + " for case 1");
        String var_2_0 = "8606335540";
        int expected_2 = phonepad.fingerMovement(var_2_0);
        System.out.println(((expected_2 == 16) ? "Passed" : "Failed") + " for case 2");
        String var_3_0 = "8606574276";
        int expected_3 = phonepad.fingerMovement(var_3_0);
        System.out.println(((expected_3 == 21) ? "Passed" : "Failed") + " for case 3");

    }

}