

public class Average {
	
	private Average(){}
	
	public static void main(String[] args) {
		int count = 0;
		double sum = 0.0;
		double[] value = {0.0, 5.0, 6.0,
				 3.0, 7.0, 32.0};
		for(int i = 0; i < value.length; i++) {
			sum += value[i];
			count++;
		}
		
		double average = sum / count;
		
		StdOut.println("Average is " + average);
		
	}

}
