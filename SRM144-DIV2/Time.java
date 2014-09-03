public class Time {

	public String whatTime(int seconds){
		
		int hr = 0;
		int min = 0;
		int sec = 0;
		int tempMin = 0;
		
		{
			
			hr = seconds/3600;
			tempMin = (seconds - hr*3600);
			min = tempMin / 60 ;
			sec = tempMin % 60;
		}
			
		
		return hr + ":" + min + ":" + sec;
	}
}
