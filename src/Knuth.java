

public class Knuth {
	private Knuth(){}
	
	public static void shuffle(Object[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = (int) (Math.random() * (i + 1));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}
	
	public static void shuffleAlternate(Object[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int)(Math.random() * (n-i));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}
	
	public static void main(String[] args) {
		String[] a = {"2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC",
				 "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD",
				 "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH",
				 };
		
		Knuth.shuffle(a);
		for ( int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}

	}
}