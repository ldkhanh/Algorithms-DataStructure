

public class Cat {
	
	private Cat(){}
	
	public static void main(String[] args) {
		Out out = new Out("Out.txt");
		
		//In in = new In("in1.txt");
		//String s = in.readAll();
		out.println("This is");
		//in.close();
		
		//In in2 = new In("in2.txt");
		//String s2 = in.readAll();
		out.println("a tiny\ntest.");
		//in2.close();
		
		out.close();
		
	}

}
