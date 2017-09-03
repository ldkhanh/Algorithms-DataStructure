import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/* Correct version*/
public class ArrayManipulation3 {
	static class Event implements Comparable<Event> {
		int x;
		long add;

		Event(int x, long add) {
			this.x = x;
			this.add = add;
		}
		@Override
		public int compareTo(Event o) {
			return x - o.x;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();

		Event[] es = new Event[2*m];
		for (int i = 0; i < m; ++i) {
			int a = in.nextInt();
			int b = in.nextInt();
			long add = in.nextLong();
			es[2*i + 0] = new Event(a, add);
			es[2*i + 1] = new Event(b+1, -add);
		}

		Arrays.sort(es);
		long ans = Long.MIN_VALUE;
		long cur = 0;
		for (int i = 0; i < es.length;) {
			if (es[i].x > n) {
				break;
			}
			int j = i;
			while (j < es.length && es[i].x == es[j].x) {
				cur += es[j++].add;
			}
			ans = Math.max(ans,cur);
			i = j;
		}
		out.println(ans);
		out.close();
	}
}












