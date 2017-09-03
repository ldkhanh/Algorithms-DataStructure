

import java.util.Arrays;

public class BinarySearch {

	private BinarySearch(){}
	
	public static int indexOf(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) /2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	@Deprecated 
	public static int rank(int key, int[] a) {
		return indexOf(a, key);
	}
	
	public static void main(String[] args) {

        // read the integers from a file
        //In in = new In("tinyW.txt");
        int[] whitelist = {84,
        		48,
        		68,
        		10,
        		18,
        		98,
        		12,
        		23,
        		54,
        		57,
        		33,
        		16,
        		77,
        		11,
        		29};

        // sort the array
        Arrays.sort(whitelist);
        
        if (BinarySearch.indexOf(whitelist, 323) != -1) {
        	System.out.println("Correct");
        } else {
        	System.out.println("Error");
        }
        
        // read integer key from standard input; print if not in whitelist
       
    }
}
