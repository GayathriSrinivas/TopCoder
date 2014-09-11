//SRM 168 DIV 2
public class StairClimb {
	
	private static final int NUM_STRIDES_LANDING = 2;
	
	public int stridesTaken(int[] flights, int stairsPerStride) {
	
		int numOfStrides = 0;
		
		for (int i = 0; i < flights.length; i++) {
			numOfStrides += flights[i] / stairsPerStride;
			
			if(flights[i] % stairsPerStride > 0) {
				numOfStrides += 1;
			}
			
			if(i != flights.length - 1){
				numOfStrides += NUM_STRIDES_LANDING;
			}
		}
		return numOfStrides;
	}
}
