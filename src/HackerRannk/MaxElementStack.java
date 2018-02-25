import java.io.*;
import java.util.*;
import java.text.*;

public class MaxElementStack {
  public static void main(String[] args) {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> track = new Stack<Integer>();

    Scanner sc = new Scanner(System.in);
    String N = sc.nextLine();
    for (int i = 0; i < Integer.parseInt(N); i++) {
      String line = sc.nextLine();
      char query = line.charAt(0);
      if (query == '1') {
        int n = Integer.parseInt(line.substring(2,line.length()));
        if (st.isEmpty()) {
          st.push(n);
          track.push(n);
          System.out.println("Push st: "+n);
          System.out.println("Push track: "+n);
        } else {
          int max = track.peek();
          track.push(Math.max(max,n));
          st.push(n);
          System.out.println("Push st: "+n);
          System.out.println("Push track: "+Math.max(max,n));
        }
      } else if (query == '2') {
        System.out.println("Delete St : " + st.pop());
        System.out.println("Delete Track: " +track.pop());
      } else if (query == '3') {
        System.out.println(track.peek());
      }
    }
  }
}
